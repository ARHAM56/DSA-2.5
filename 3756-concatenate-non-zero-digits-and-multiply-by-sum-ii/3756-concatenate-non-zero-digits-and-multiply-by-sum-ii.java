import java.util.*;

class Solution {

    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // positions of non-zero digits
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digit = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digit.add(d);
            }
        }

        int m = digit.size();

        long[] prefixSum = new long[m + 1];
        long[] prefixNum = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;
        for (int i = 1; i <= m; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + digit.get(i);
            prefixNum[i + 1] = (prefixNum[i] * 10 + digit.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {

            int l = queries[k][0];
            int r = queries[k][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r);

            if (left == right) {
                ans[k] = 0;
                continue;
            }

            long sum = prefixSum[right] - prefixSum[left];

            long x = (prefixNum[right]
                    - (prefixNum[left] * pow10[right - left]) % MOD
                    + MOD) % MOD;

            ans[k] = (int)((x * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}