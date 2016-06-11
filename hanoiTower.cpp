#include <iostream>

using namespace std;

void hanoiTowerMove(int num, char from, char by, char to);
int main(void)
{
	hanoiTowerMove(3, 'A', 'B', 'C'); //Move from stick A to stick B 
	return 0;
}

void hanoiTowerMove(int num, char from, char by, char to)
{
	if (num == 1)
	{
		cout << "1��° ������ " << from << "���� " << to << "�� �̵�!!" << endl;
	}
	else
	{
		hanoiTowerMove(num - 1, from, to, by);
		cout << num << "��° ������ " << from << "���� " << to << "�� �̵�!!" << endl;
		hanoiTowerMove(num - 1, by, from, to);
	}
}