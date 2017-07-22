#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ALGraphDFS.h"
#include "DLinkedList.h"
#include "ListBaseStack.h"

int WhoIsPrecede(int data1, int data2)
{
	if (data1 < data2)
		return 0;
	else
		return 1;
}

// �׷����� �ʱ�ȭ
void GraphInit(ALGraph * pg, int nv)
{
	int i = 0;

	pg->adjList = (List *)malloc(sizeof(List)*nv);

	pg->numV = nv;
	pg->numE = 0;

	for (i = 0; i < nv; i++)
	{
		ListInit(&pg->adjList[i]);
		SetSortRule(&pg->adjList[i], WhoIsPrecede);
	}

	pg->visitInfo = (int *)malloc(sizeof(int)*nv);

	memset(pg->visitInfo, 0, sizeof(int)*nv);
}

// �׷����� ���ҽ� ����
void GraphDestroy(ALGraph * pg)
{
	if (pg->adjList != NULL)
		free(pg->adjList);

	// �Ҵ�� �迭 �Ҹ�!
	if (pg->visitInfo != NULL)
		free(pg->visitInfo);
}

// ������ �߰�
void AddEdge(ALGraph * pg, int fromV, int toV)
{
	LInsert(&pg->adjList[fromV], toV);
	LInsert(&pg->adjList[toV], fromV);

	pg->numE++;
}

// ������ ���� ���
void ShowGraphEdgeInfo(ALGraph * pg)
{
	int i;
	int vx = 0;

	for (i = 0; i < pg->numV; i++)
	{
		printf("%c�� ����� ����: ", i + 65);
		if (LFirst(&pg->adjList[i], &vx))
		{
			printf("%c ", vx + 65);

			while (LNext(&pg->adjList[i], &vx))
				printf("%c ", vx + 65);
		}
		printf("\n");
	}
}

int VisitVertex(ALGraph * pg, int visitV) // �湮������ üŷ�ϴ� �Լ�
{
	if (pg->visitInfo[visitV] == 0)
	{
		pg->visitInfo[visitV] = 1;
		printf("%c ", visitV + 65);
		return TRUE;
	}

	return FALSE; // �湮 ����
}

// ������ ���� ��� : Depth First Search ���
void DFShowGraphVertex(ALGraph * pg, int startV)
{
	Stack stack;
	int visitV = startV;
	int nextV;

	StackInit(&stack);
	VisitVertex(pg, visitV); // ������ �湮
	SPush(&stack, visitV); // ���� ������ ������ ��������

	while (LFirst(&pg->adjList[visitV], &nextV) == TRUE) // �湮 �������� ����� ù��° ������ ã�´�.
	{
		int visitFlag = FALSE;

		if (VisitVertex(pg, nextV) == TRUE) // �湮�� ����
		{
			SPush(&stack, visitV);
			visitV = nextV;
			visitFlag = TRUE;
		}
		else // �湮�� �������� ���ϸ�
		{
			while (LNext(&pg->adjList[visitV], &nextV) == TRUE) // �湮 �������� ����� �ٸ� ������ ã�´�.
			{
				if (VisitVertex(pg, nextV) == TRUE) // �湮���� ���� ������ ã���� ��
				{
					SPush(&stack, visitV);
					visitV = nextV;
					visitFlag = TRUE;
					break;
				}
			}
		}

		if (visitFlag == FALSE)
		{
			// ������ ��� Ž���� ���������� �ǵ��� �� ���̴�.
			if (SIsEmpty(&stack) == TRUE)
				break;
			else
				visitV = SPop(&stack); // ���� �ǵ��� ����.
		}
	}

	// ������ Ž���� ���ؼ� Ž�� ���� �ʱ�ȭ
	memset(pg->visitInfo, 0, sizeof(int) * pg->numV);
}