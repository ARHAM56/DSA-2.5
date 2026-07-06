class Solution {
    public int divisibleGame(int[] nums) {

        final int MOD = 1_000_000_007;

        HashSet<Integer> set = new HashSet<>();
        int maxNum = 0;

        // Collect all possible k values (divisors > 1)
        for (int x : nums) {
            maxNum = Math.max(maxNum, x);

            for (int d = 2; d * d <= x; d++) {
                if (x % d == 0) {
                    set.add(d);
                    set.add(x / d);
                }
            }

            if (x > 1)
                set.add(x);
        }

        // Case where no number is divisible
        set.add(maxNum + 1);

        long bestScore = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for (int k : set) {

            long cur = 0;
            long maxSum = Long.MIN_VALUE;

            // Kadane's Algorithm
            for (int x : nums) {

                long val = (x % k == 0) ? x : -x;

                cur = Math.max(val, cur + val);
                maxSum = Math.max(maxSum, cur);
            }

            if (maxSum > bestScore) {
                bestScore = maxSum;
                bestK = k;
            } else if (maxSum == bestScore && k < bestK) {
                bestK = k;
            }
        }

        long ans = (bestScore % MOD) * bestK;
        ans %= MOD;

        if (ans < 0)
            ans += MOD;

        return (int) ans;
    }
}