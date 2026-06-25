class Solution {

    class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        
        for (int i = 0; i < n; i++) {
            pq.offer(new Node(matrix[i][0], i, 0));
        }

        int ans = -1;

        for (int i = 0; i < k; i++) {

            Node curr = pq.poll();
            ans = curr.val;

            int r = curr.row;
            int c = curr.col;

            
            if (c + 1 < m) {
                pq.offer(new Node(matrix[r][c + 1], r, c + 1));
            }
        }

        return ans;
    }
}