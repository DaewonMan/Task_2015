#include <stdio.h>
#include <stdlib.h>
#include "NameCard.h"

// NameCard ����ü ������ ���� �Ҵ� �� �ʱ�ȭ �� �ּ� �� ��ȯ
NameCard * MakeNameCard(char * name, char * phone)
{
	NameCard * nc = (NameCard * )malloc(sizeof(NameCard));
	/** ���ڿ� �Ҵ�� �߸��� ����**/
	//nc->name[0] = name;
	//nc->phone[0] = phone;
	strcpy(nc->name, name);
	strcpy(nc->phone, phone);

	return nc;
}

// NameCard ����ü ������ ���� ���
void ShowNameCardInfo(NameCard * pcard)
{
	printf("�̸� : %s, ��ȭ��ȣ : %s\n", pcard->name, pcard->phone);
}

// �̸��� ������ 0, �ٸ��� 0�� �ƴ� �� ��ȯ
int NameCompare(NameCard * pcard, char * name)
{
	/** ���ڿ� �񱳽� �߸��� �񱳹�� **/
	/*
	if (pcard->name == name)
		return 0;
	else
		return 1;
	*/

	return strcmp(pcard->name, name);
}

// ��ȭ��ȣ ������ ����
void ChangePhoneNum(NameCard * pcard, char * phone)
{
	//pcard->phone[0] = phone; // �߸��� ���
	strcpy(pcard->phone, phone);
}