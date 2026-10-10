class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;

        if (curr == null) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head.next;
        }

        ListNode temp = head;

        while (curr.next != null) {
            curr = curr.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}