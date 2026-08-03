class Solution {
    public int maxSubArray(int[] nums) {

        int prefix = 0;
        int minPrefix = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            

            // Maximum subarray ending at i
            maxSum = Math.max(maxSum, prefix - minPrefix);
             // Update minimum prefix sum
            minPrefix = Math.min(minPrefix, prefix);

           
        }

        return maxSum;
    }
}