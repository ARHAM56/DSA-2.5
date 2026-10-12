/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode kth(ListNode temp , int k )
    {
        ListNode curr = temp ;
        int count=1;

        while(curr!=null && count<k )
        {
            curr=curr.next;
            count++;
        }
        return curr;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;

            
        }
        return pre;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null && k<1)
        {
            return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prevGroup=dummy;
        ListNode temp=head;
        ListNode preserve;
        ListNode nextNode;
        while(temp!=null)
        {
            preserve=kth(temp , k);
            
            if(preserve==null)
            {
                break;

            }
            nextNode=preserve.next;
            preserve.next=null;

            ListNode rev= reverse(temp);
            prevGroup.next=rev; 
            temp.next=nextNode;
            prevGroup=temp;
            temp=nextNode;


            
        }
        return dummy.next;
        
    }
}