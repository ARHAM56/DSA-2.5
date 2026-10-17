import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                int p = num % 10;
                sum += p;
                num = num / 10;
            }

            ans[i] = sum;
        }

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = ans[i];
        }

      
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i][0], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(nums[i]) == i) {
                continue;
            }

            int j = i;
            int count = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                count++;
            }

            swaps += count - 1;
        }

        return swaps;
    }
}