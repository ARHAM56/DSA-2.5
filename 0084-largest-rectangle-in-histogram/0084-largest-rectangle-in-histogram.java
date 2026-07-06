class Solution {

    public int[] nearestsmallerleft(int[] A) {
        Stack<Integer> st = new Stack<>();
        int n = A.length;
        int[] nsol = new int[n];

        nsol[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsol[i] = -1;
            } else {
                nsol[i] = st.peek();
            }

            st.push(i);
        }

        return nsol;
    }

    public int[] nearestsmallerright(int[] A) {
        Stack<Integer> st = new Stack<>();
        int n = A.length;
        int[] nsor = new int[n];

        nsor[n - 1] = -1;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {   // fixed

            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsor[i] = -1;
            } else {
                nsor[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (nsor[i] == -1) {
                nsor[i] = n;
            }
        }

        return nsor;
    }

    public int largestRectangleArea(int[] heights) {

        int[] nsol = nearestsmallerleft(heights);
        int[] nsor = nearestsmallerright(heights);

        int ans = 0;

        for (int i = 0; i < heights.length; i++) {

            int w = nsor[i] - nsol[i] - 1;   // fixed
            int h = heights[i];

            int area = w * h;
            ans = Math.max(ans, area);
            
        }

        return ans;
    }
}