class Solution {
    public int countKDifference(int[] nums, int k) {

        int i = 0;
        int j = 1;
        int count = 0;

        while (i < nums.length - 1) {

            if (j == nums.length) {
                i++;
                j = i + 1;
                continue;
            }

            int dif = Math.abs(nums[j] - nums[i]);

            if (dif == k) {
                count++;
            }

            j++;
        }

        return count;
    }
}