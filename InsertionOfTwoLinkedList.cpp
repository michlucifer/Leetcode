/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
       int nLenA = 1, nLenB = 1;
		if (headA == NULL || headB == NULL)
			return NULL;
		ListNode *PointA = headA, *PointB = headB;
		while (PointA->next != NULL)//遍历A链表，计算链表长度
		{
			nLenA++;
			PointA = PointA->next;
		}
		while (PointB->next != NULL)//遍历B链表，计算链表长度
		{
			nLenB++;
			PointB = PointB->next;
		}
		PointA = headA;
		PointB = headB;
		if (nLenA >= nLenB)
		{
			for (int nTemp = 0; nTemp < nLenA - nLenB; nTemp++)
			{
				PointA = PointA->next;
			}
			for (int nTemp = 0; nTemp < nLenB; nTemp++)
			{
				if (PointA->val == PointB->val)
				{
					return PointA;
				}
				PointA = PointA->next;
				PointB = PointB->next;
			}
			return NULL;
		}
		else
		{
			for (int nTemp = 0; nTemp < nLenB - nLenA; nTemp++)
			{
				PointB = PointB->next;
			}
			for (int nTemp = 0; nTemp < nLenA; nTemp++)
			{
				if (PointA->val == PointB->val)
				{
					return PointA;
				}
				PointA = PointA->next;
				PointB = PointB->next;
			}
			return NULL;
		} 
    }
};
