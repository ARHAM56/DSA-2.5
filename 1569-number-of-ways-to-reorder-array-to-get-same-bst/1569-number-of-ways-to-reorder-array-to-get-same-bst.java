

class Solution {
    static final long MOD = 1_000_000_007L;
    long[][] dp;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][i] = 1;

            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1]
                          + dp[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        return (int) ((solve(list) - 1 + MOD) % MOD);
    }

    long solve(List<Integer> nums) {
        if (nums.size() <= 2) return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int x = nums.get(i);

            if (x < root) left.add(x);
            else right.add(x);
        }

        long l = solve(left);
        long r = solve(right);

        long ways = dp[nums.size() - 1][left.size()];

        return ways * l % MOD * r % MOD;
    }
}