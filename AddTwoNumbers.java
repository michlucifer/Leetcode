/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode p3 = newHead;
        
        int add = 0;
        
        while(p1 != null || p2 != null) {
            if(p1 != null) {
                add += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                add += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(add%10);
            p3 = p3.next;
            add = add/10;
        }
        if(add == 1) {
            p3.next = new ListNode(1);
        }
        return newHead.next;
    }
}
