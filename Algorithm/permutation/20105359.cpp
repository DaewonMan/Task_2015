/****************************************************************
*																*
* Problem :														*
*		���ĵ� ���� ���ϱ�										*
*																*
****************************************************************/

/****************************************************************
*																*
* ���δ��б� ����������Ŵ��� ��ǻ�Ͱ��к� 4 �г�				*
*												20105359 ����	*
*																*
****************************************************************/
#include <iostream>
#include <cstdlib>
#include <fstream>
using namespace std;
char perarr[13];
int index = 0;

int fac(int n)
{
	if (n <= 1) // base case
		return 1;
	else // recursive step
		return n*fac(n - 1);
}
void permutation(char * arr, int n, int o)
{
	int f = 0, share = 0, remnant = 0;

	for (int i = n; i > 0; i--)
	{
		f = fac(i - 1); // �� ������ ���ĺ������� case num �Ҵ�
		share = (o - 1) / f; // ���� �� ���� ���ĺ� �ε���
		o -= share * f;
		while (1)
		{
			if (arr[share] != 'z')
			{
				perarr[index++] = arr[share];
				arr[share] = 'z';
				break;
			}
			share++;
		}
		// �������ķ� ���ĺ� ����
		for (int j = 0; j < n-1;j++)
		{
			char temp = 0;
			for (int k = j + 1; k < n; k++)
			{
				if (arr[j] > arr[k])
				{
					temp = arr[j];
					arr[j] = arr[k];
					arr[k] = temp;
				}
			}
		}
	}
	index = 0;
}

int main(void)
{
	ifstream inStream;
	int numTestCases = 0;
	int num = 0, order = 0;

	// ���� ���� �� ���� ���� �� ����ó��
	inStream.open("input.txt");
	if (inStream.fail())
	{
		cerr << "Input file opening failed. \n";
		exit(1);
	}
	// �ݺ� Ƚ�� �Է�
	inStream >> numTestCases;
	for (int i = 0; i < numTestCases; i++)
	{
		inStream >> num >> order; // ������ ������ �Է�
		char alpha[13] = "abcdefghijkl";
		char arr[13] = "";
		// �Է� ���� ��ŭ ���ĺ� �Ҵ�
		for (int i = 0; i < num; i++) arr[i] = alpha[i];
		//��� ���
		permutation(arr, num, order);
		cout << perarr << endl;
		// �������� �ʱ�ȭ
		for (int i = 0; i < num; i++) perarr[i] = ' ';
	}
	inStream.close();
	return 0;
}
