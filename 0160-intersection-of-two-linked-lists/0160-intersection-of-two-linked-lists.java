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
/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode slow=headB;
        ListNode fast=headA;
        
        while(slow!=fast)
        {
           if(slow==null)
           {
                slow=headA;

           }
           else
           {
                slow=slow.next;
           }
           if(fast==null)
           {
                fast=headB;

           }
           else
           {
                fast=fast.next;

           }

        }
        return fast;

    }
}
