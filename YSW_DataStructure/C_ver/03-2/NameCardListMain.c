/*
   hot blood data structure
   Problem : 03-2
*/
#include <stdio.h>
#include <stdlib.h>
#include "ArrayList.h"
#include "NameCard.h"

int main(void)
{
	List list;
	NameCard nc;
	NameCard * pp;

	ListInit(&list);

	/** ������ ���� **/
	//pp = (NameCard *)malloc(sizeof(NameCard));
	pp = MakeNameCard("James jo", "010-1111-2222");
	LInsert(&list, pp);

	//pp = (NameCard *)malloc(sizeof(NameCard));
	pp = MakeNameCard("mike kim", "010-2222-3333");
	LInsert(&list, pp);

	//pp = (NameCard *)malloc(sizeof(NameCard));
	pp = MakeNameCard("chals lee", "010-3333-4444");
	LInsert(&list, pp);

	/** ����� �������� �� ��� **/
	printf("���� �������� �� : %d \n", LCount(&list));

	if (LFirst(&list, &pp))
	{
		ShowNameCardInfo(pp);

		while (LNext(&list, &pp))
			ShowNameCardInfo(pp);
	}
	printf("\n");
	/** mike kim�� ���� ã�� ��� **/
	printf("mike kim�� ����\n");
	if (LFirst(&list, &pp))
	{
		if (NameCompare(pp, "mike kim") == 0)
			ShowNameCardInfo(pp);
		while (LNext(&list, &pp))
		{
			if (NameCompare(pp, "mike kim") == 0)
				ShowNameCardInfo(pp);
		}
	}
	printf("\n");

	/** mike kim�� ���� ã�� ��ȭ��ȣ ���� **/
	printf("mike kim�� ���� ã�� ��ȭ��ȣ ����\n");
	if (LFirst(&list, &pp))
	{
		if (NameCompare(pp, "mike kim") == 0)
			ChangePhoneNum(pp, "010-9999-9999");
		while (LNext(&list, &pp))
		{
			if (NameCompare(pp, "mike kim") == 0)
				ChangePhoneNum(pp, "010-9999-9999");
		}
	}
	printf("\n");

	/** chals lee�� ���� ã�� ���� **/
	printf("chals lee�� ���� ã�� ����\n");
	if (LFirst(&list, &pp))
	{
		if (NameCompare(pp, "chals lee") == 0)
			LRemove(&list);
		while (LNext(&list, &pp))
		{
			if (NameCompare(pp, "chals lee") == 0)
				LRemove(&list);
		}
	}

	/** ����� �������� �� ��� **/
	printf("���� �������� �� : %d \n", LCount(&list));

	if (LFirst(&list, &pp))
	{
		ShowNameCardInfo(pp);

		while (LNext(&list, &pp))
			ShowNameCardInfo(pp);
	}
	printf("\n");

	return 0;
}

