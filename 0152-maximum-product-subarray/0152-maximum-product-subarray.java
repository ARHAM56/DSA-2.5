
public class Solution {
    public int maxProduct(final int[] A) {

        int n = A.length;

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = A[0];
        dpMin[0] = A[0];

        int ans = A[0];

        for (int i = 1; i < n; i++) {

            if (A[i] >= 0) {
                dpMax[i] = Math.max(A[i], dpMax[i - 1] * A[i]);
                dpMin[i] = Math.min(A[i], dpMin[i - 1] * A[i]);
            } else {
                dpMax[i] = Math.max(A[i], dpMin[i - 1] * A[i]);
                dpMin[i] = Math.min(A[i], dpMax[i - 1] * A[i]);
            }

            ans = Math.max(ans, dpMax[i]);
        }

        return ans;
    }
}