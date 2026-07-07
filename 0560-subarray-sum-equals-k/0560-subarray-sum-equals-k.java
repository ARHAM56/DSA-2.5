class Solution {

    Integer[] dp;

    public int subarraySum(int[] nums, int k) {
        dp = new Integer[nums.length];
        return solve(nums, 0, k);
    }

    private int solve(int[] nums, int start, int k) {

        if (start == nums.length)
            return 0;

        if (dp[start] != null)
            return dp[start];

        int sum = 0;
        int count = 0;

        for (int end = start; end < nums.length; end++) {
            sum += nums[end];

            if (sum == k)
                count++;
        }

        dp[start] = count + solve(nums, start + 1, k);

        return dp[start];
    }
}