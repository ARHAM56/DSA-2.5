import java.util.*;

class Solution {

    public int[] nearestsmallerleft(int[] A) {
        int n = A.length;
        int[] nsol = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            nsol[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return nsol;
    }

    public int[] nearestsmallerright(int[] A) {
        int n = A.length;
        int[] nsor = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            nsor[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nsor;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nsol = nearestsmallerleft(heights);
        int[] nsor = nearestsmallerright(heights);

        int ans = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = nsor[i] - nsol[i] - 1;
            int area = width * heights[i];

            ans = Math.max(ans, area);
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}