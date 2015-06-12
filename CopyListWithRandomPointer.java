/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode copyHead = null;
        RandomListNode copyCur = null;
        RandomListNode cur = head;
        
        while(cur != null) {
            copyCur = new RandomListNode(cur.label);
            if(copyHead == null) {
                copyHead = copyCur;
            }
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = cur.next.next;
        }
        
        cur = head;
        copyCur = copyHead;
        while(cur != null) {
            if(cur.random != null) {
                copyCur.random = cur.random.next;
            }
            cur = cur.next.next;
            if(copyCur.next != null) {
                copyCur = copyCur.next.next;
            }
        }
        
        cur = head;
        copyCur = copyHead;
        while(cur != null) {
            cur.next = cur.next.next;
            if(copyCur.next != null) {
                copyCur.next = copyCur.next.next;
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }
        
        return copyHead;
    }
}
