#include <stdio.h>
#include <stdlib.h>


void Swap(int arr[], int idx1, int idx2)
{
	int temp = arr[idx1];
	arr[idx1] = arr[idx2];
	arr[idx2] = temp;
}

int Partition(int arr[], int left, int right)
{
	int pivot = left;
	int low = left + 1;
	int high = right;

	while (low <= high)
	{
		while (arr[pivot] > arr[low]) // �Ǻ����� ū ���� �ε��� ã�´�.
			low++;
		while (arr[pivot] < arr[high]) // �Ǻ����� ���� ���� �ε��� ã�´�.
			high--;

		if (low <= high) // �Ǻ����� ū ���� ���� �� ��ȯ�Ͽ� ���� ���� ���ʿ� ū ���� �����ʿ� ������ ��ȯ
			Swap(arr, low, high);
	}

	Swap(arr, pivot, high); 

	return high;
}

void QuickSort(int arr[], int left, int right)
{
	int pivot = 0;
	if (left <= right)
	{
		pivot = Partition(arr, left, right);
		QuickSort(arr, left, pivot-1);
		QuickSort(arr, pivot+1, right);
	}
}

int main(void)
{
	int arr[4] = { 3, 2, 4, 1 };
	int i;

	QuickSort(arr, 0, sizeof(arr) / sizeof(int) - 1);

	for (i = 0; i < 4; i++)
		printf("%d ", arr[i]);
	printf("\n");

	return 0;

}