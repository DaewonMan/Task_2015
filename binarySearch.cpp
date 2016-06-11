/* 
   ����Ž�� ����Ƚ���� ��
   n = 500
   n = 5000
   n = 50000 �϶� 
   ����Ž�� �˰����� ����Ƚ���� �˾ƺ���!
*/

#include <iostream>

using namespace std;

int BSearch(int arr[], int id, int target)
{
	int first = 0;
	int last = id - 1;
	int mid = 0;
	int cnt = 0;

	while (first <= last) 
	{
		mid = (first + last) / 2;
		if (arr[mid] == target) return mid; // Ÿ���� ã���� �ε��� ��ȯ
		else if (arr[mid] > target) last = mid - 1;
		else first = mid + 1;
		cnt++; // ����Ƚ�� ����
	}
	cout << "����Ƚ�� : " << cnt << endl;
	return -1;
}
int main(void)
{
	int arr1[500] = {0, };
	int arr2[5000] = {0, };
	int arr3[50000] = {0, };
	int idx;

	idx = BSearch(arr1, sizeof(arr1)/sizeof(int), 1); // �迭arr1�� ������� 1�� ã�ƶ�

	if (idx == -1) cout << "Ž������" << endl;
	else cout << "Ÿ�� ���� �ε��� : " << idx << endl;
	
	idx = BSearch(arr2, sizeof(arr2) / sizeof(int), 1); // �迭arr2�� ������� 1�� ã�ƶ�

	if (idx == -1) cout << "Ž������" << endl;
	else cout << "Ÿ�� ���� �ε��� : " << idx << endl;

	idx = BSearch(arr3, sizeof(arr3) / sizeof(int), 1); // �迭 arr3�� ������� 1�� ã�ƶ�

	if (idx == -1) cout << "Ž������" << endl;
	else cout << "Ÿ�� ���� �ε��� : " << idx << endl;

	return 0;
}