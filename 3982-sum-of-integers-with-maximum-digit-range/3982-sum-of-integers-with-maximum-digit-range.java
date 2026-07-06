class Solution {
    public int maxDigitRange(int[] nums) {

        int maxRange = Integer.MIN_VALUE;
        int nm = 0;

        
        for (int i = 0; i < nums.length; i++) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int n = nums[i];

            while (n > 0) {
                int digit = n % 10;

                if (digit > max) {
                    max = digit;
                }

                if (digit < min) {
                    min = digit;
                }

                n = n / 10;
            }

            int ans = max - min;

            if (ans > maxRange) {
                maxRange = ans;
            }
        }

        
        for (int i = 0; i < nums.length; i++) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int n = nums[i];

            while (n > 0) {
                int digit = n % 10;

                if (digit > max) {
                    max = digit;
                }

                if (digit < min) {
                    min = digit;
                }

                n = n / 10;
            }

            int ans = max - min;

            if (ans == maxRange) {
                nm += nums[i];
            }
        }

        return nm;
    }
}  