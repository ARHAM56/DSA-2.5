
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find length
        int n = 0;
        ListNode curr = head;

        while (curr != null) {
            n++;
            curr = curr.next;
        }

        // Remove unnecessary rotations
        k = k % n;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (k != 0) {

            curr = head;
            ListNode l = dummy;

            
            while (curr.next != null) {
                l = curr;
                curr = curr.next;
            }

            
            l.next = null;

            
            curr.next = head;
            head = curr;

            dummy.next = head;

            k--;
        }

        return dummy.next;
    }
}
