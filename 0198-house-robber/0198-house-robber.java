import java.util.Arrays;

class Solution {

    int[] storage;

    public int solve(int[] nums, int i) {

        if (i < 0) {
            return 0;
        }

        if (storage[i] != -1) {
            return storage[i];
        }

        int inc = solve(nums, i - 2) + nums[i];
        int exc = solve(nums, i - 1);

        storage[i] = Math.max(inc, exc);

        return storage[i];
    }

    public int rob(int[] nums) {

        storage = new int[nums.length];
        Arrays.fill(storage, -1);

        return solve(nums, nums.length - 1);
    }
}