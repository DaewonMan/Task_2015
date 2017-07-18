#include <stdio.h>
#include <stdlib.h>
#include "Table2.h"
#include "DLinkedList2.h"

// ���̺� �ʱ�ȭ
void TBLInit(Table * pt, HashFunc * f)
{
	int i;

	for (i = 0; i < MAX_TBL; i++)
	{
		ListInit(&pt->tbl[i]);
	}

	pt->hf = f;
}

// ���̺� Ű�� ���� ����
void TBLInsert(Table * pt, Key k, Value v)
{
	int h_val = pt->hf(k);
	Slot st = {k, v};

	LInsert(&pt->tbl[h_val], st);
}

// Ű�� �ٰŷ� ���̺��� ������ ����
Value TBLDelete(Table * pt, Key k)
{
	int h_val = pt->hf(k);
	Slot st;


	if (LFirst(&pt->tbl[h_val], &st))
	{
		if (st.key == k)
		{
			LRemove(&pt->tbl[h_val]);
			return st.val;
		}
		else
		{
			while (LNext(&pt->tbl[h_val], &st))
			{
				if (st.key == k)
				{
					LRemove(&pt->tbl[h_val]);
					return st.val;
				}
			}
		}
	}
	else
		return NULL;

}

// Ű�� �ٰŷ� ���̺��� ������ Ž��
Value TBLSearch(Table * pt, Key k)
{
	int h_val = pt->hf(k);
	Slot st;

	
	if (LFirst(&pt->tbl[h_val], &st))
	{
		if (st.key == k)
			return st.val;
		else
		{
			while (LNext(&pt->tbl[h_val], &st))
			{
				if (st.key == k)
					return st.val;
			}
		}
	}
	else
		return NULL;
}