#include <stdio.h>
#include "dbDLinkedList.h"

int main(void)
{
	//����Ʈ�� ���� �� �ʱ�ȭ
	List list;
	int data;
	ListInit(&list);

	//5���� ������ ����
	LInsert(&list, 1); LInsert(&list, 22);
	LInsert(&list, 3); LInsert(&list, 4);
	LInsert(&list, 22);

	//����� �������� ��ü ���
	printf("���� �������� ��: %d \n", LCount(&list));

	if (LFirst(&list, &data))
	{
		printf("%d ", data);

		while (LNext(&list, &data))
			printf("%d ", data);
	}
	printf("\n\n");

	//���� 22�� �˻��Ͽ� ��� ����
	if (LFirst(&list, &data))
	{
		if (data == 22)
			LRemove(&list);
		while (LNext(&list, &data))
		{
			if (data == 22)
				LRemove(&list);
		}
	}

	//���� �� �����ִ� ������ ��ü ���
	printf("���� �������� ��: %d \n", LCount(&list));

	if (LFirst(&list, &data))
	{
		printf("%d ", data);

		while (LNext(&list, &data))
			printf("%d ", data);
	}

	printf("\n\n");
	return 0;

}