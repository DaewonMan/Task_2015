#include "UsefulHeap.h"

void HeapInit(Heap * ph, PriorityComp pc)
{
	ph->numOfData = 0;
	ph->comp = pc;
}
int HIsEmpty(Heap * ph)
{
	if (ph->numOfData == 0)
		return TRUE;
	else
		return FALSE;
}

int GetParentIDX(int idx) // �θ����� �ε��� �� ��ȯ
{
	return idx / 2;
}
int GetLChildIDX(int idx) // ���� �ڽ� ����� �ε��� ��ȯ
{
	return idx * 2;
}
int GetRChildIDX(int idx) // ������ �ڽ� ����� �ε��� ��ȯ
{
	return GetLChildIDX(idx) + 1;
}

/*���� ���� �ʿ�*/
int GetHiPriChildIDX(Heap * ph, int idx) // �ڽ� ��� �� ū ���� ��´�. 
{
	if (GetLChildIDX(idx) > ph->numOfData)
		return 0;
	else if (GetLChildIDX(idx) == ph->numOfData) // �ڽĳ�尡 �ϳ��� ��
		return GetLChildIDX(idx);
	else
	{
		if (ph->comp(ph->heapArr[GetRChildIDX(idx)], ph->heapArr[GetLChildIDX(idx)]) > 0) // ph->heapArr[GetLChildIDX(idx)].pr > ph->heapArr[GetRChildIDX(idx)].pr
			return GetRChildIDX(idx);
		else
			return GetLChildIDX(idx);
	}
}

void HInsert(Heap * ph, HData data)
{
	int idx = ph->numOfData + 1;
	//HeapElem nelem = { pr, data };

	while (idx != 1)
	{
		if (ph->comp(data, ph->heapArr[GetParentIDX(idx)]) > 0) // ���ο� �����Ͱ� �θ��庸�� �켱������ ���� ���
		{
			ph->heapArr[idx] = ph->heapArr[GetParentIDX(idx)];
			idx = GetParentIDX(idx);
		}
		else
			break;
	}

	ph->heapArr[idx] = data;
	ph->numOfData += 1;
}
HData HDelete(Heap * ph)
{
	HData retData = ph->heapArr[1];
	//HeapElem lastElem = ph->heapArr[ph->numOfData];
	HData lastData = ph->heapArr[ph->numOfData];

	int parentIdx = 1;
	int childIdx;

	while (childIdx = GetHiPriChildIDX(ph, parentIdx))
	{
		if (lastData <= ph->heapArr[childIdx]) // lastData <= ph->heapArr[childIdx]
			break;
		ph->heapArr[parentIdx] = ph->heapArr[childIdx];
		parentIdx = childIdx;
	}

	ph->heapArr[parentIdx] = lastData;
	ph->numOfData -= 1;
	return retData;

}