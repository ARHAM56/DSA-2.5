class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {

        String s = String.valueOf(n);
        int len = s.length();
        int m = digits.length;

        int ans = 0;

        // Numbers with fewer digits
        for (int i = 1; i < len; i++) {
            ans += Math.pow(m, i);
        }

        // Numbers with same length
        for (int i = 0; i < len; i++) {

            boolean same = false;

            for (String d : digits) {

                char c = d.charAt(0);

                if (c < s.charAt(i)) {
                    ans += Math.pow(m, len - i - 1);
                } else if (c == s.charAt(i)) {
                    same = true;
                    break;
                } else {
                    break;
                }
            }

            if (!same)
                return ans;
        }

        return ans + 1;
    }
}