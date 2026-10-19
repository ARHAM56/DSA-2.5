
import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        int Max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Max = Math.max(nums[i], Max);
        }

        int[] count = new int[Max + 1];

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        List<Integer> list = new ArrayList<>();

        int index = 0;

        for (int i = 0; i <= Max; i++) {

            while (count[i] > 0) {

                if (i == target) {
                    list.add(index);
                }

                index++;
                count[i]--;
            }
        }

        return list;
    }
}
