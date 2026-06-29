class Solution {
    public int numSquares(int A) {
        if (A == 0)
            return 0;

        int[] dp = new int[A + 1];

        dp[0] = 0;

        for (int i = 1; i <= A; i++) {

            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        return dp[A];
        
    }
}