#include <stdio.h>
#include <stdlib.h>
#include "Table.h"

// ���̺� �ʱ�ȭ
void TBLInit(Table * pt, HashFunc * f)
{
	int i;

	for (i = 0; i < MAX_TBL; i++)
	{
		pt->tbl[i].key = 0;
		pt->tbl[i].val = NULL;
		pt->tbl[i].status = EMPTY;
	}

	pt->hf = f;
}

// ���̺� Ű�� ���� ����
void TBLInsert(Table * pt, Key k, Value v)
{
	pt->tbl[pt->hf(k)].key = k;
	pt->tbl[pt->hf(k)].val = v;
	pt->tbl[pt->hf(k)].status = INUSE;
}

// Ű�� �ٰŷ� ���̺��� ������ ����
Value TBLDelete(Table * pt, Key k)
{
	
	if (TBLSearch(pt, k) != NULL)
	{

		pt->tbl[pt->hf(k)].key = 0;
		pt->tbl[pt->hf(k)].status = DELETED;

		return pt->tbl[pt->hf(k)].val;
	}
	else
		return NULL;

}

// Ű�� �ٰŷ� ���̺��� ������ Ž��
Value TBLSearch(Table * pt, Key k)
{
	if (pt->tbl[pt->hf(k)].status == INUSE)
		return pt->tbl[pt->hf(k)].val;
	else
		return NULL;
}