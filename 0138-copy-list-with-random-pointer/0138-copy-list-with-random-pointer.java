
class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

      
        Node temp = head;

        while (temp != null) {
            Node nn = new Node(temp.val);
            Node tn = temp.next;

            temp.next = nn;
            nn.next = tn;

            temp = nn.next;
        }

       
        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }

            temp = temp.next.next;
        }

       
        Node c1 = head;
        Node c2 = head.next;

        Node ans = c2;

        while (c1 != null && c2 != null) {
            Node n1 = c2.next;
            Node n2;

            if (n1 == null) {
                n2 = null;
            } else {
                n2 = n1.next;
            }

            c1.next = n1;
            c2.next = n2;

            c1 = n1;
            c2 = n2;
        }

        return ans;
    }
}
