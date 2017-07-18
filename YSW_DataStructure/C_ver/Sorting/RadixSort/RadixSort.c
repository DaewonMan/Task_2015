#include <stdio.h>
#include "ListBaseQueue.h"

#define BUCKET_NUM 10

void RadixSort(int arr[], int num, int maxLen)
{
	Queue buckets[BUCKET_NUM];

	int i, j, k;
	int cipher = 1; //�ڸ���
	int n_cipher = 0; // �ش� �ڸ����� ����

	for (i = 0; i < BUCKET_NUM; i++) // ��Ŷ �ʱ�ȭ
		QueueInit(&buckets[i]);

	for (i = 0;i < maxLen;i++)
	{
		for (j = 0; j < num; j++)
		{
			n_cipher = (arr[j] / cipher) % 10; //N��° �ڸ����� ���� ����

			Enqueue(&buckets[n_cipher], arr[j]); //j��° �迭�� ���� N��° ��Ŷ�� enqueue
		}

		for (j = 0, k = 0;j < BUCKET_NUM;j++)
		{
			while (!QIsEmpty(&buckets[j]))
				arr[k++] = Dequeue(&buckets[j]);
		}

		cipher *= 10; //�������� ����
	}
}

int main(void)
{
	int arr[7] = {13, 212, 14, 7141, 10987, 6, 15};
	int i;
	int num = sizeof(arr) / sizeof(int);
	int maxLen = 5;

	RadixSort(arr, num, maxLen);

	for (i = 0; i < num; i++)
		printf("%d ", arr[i]);
	printf("\n");

	return 0;

}