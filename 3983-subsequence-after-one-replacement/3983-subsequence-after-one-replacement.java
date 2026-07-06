class Solution {
    public boolean canMakeSubsequence(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[] pref = new int[n];
        int[] suff = new int[n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && s.charAt(i) != t.charAt(j))
                j++;

            pref[i] = (j == m) ? m : j;
            if (j < m)
                j++;
        }

        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && s.charAt(i) != t.charAt(j))
                j--;

            suff[i] = j;
            if (j >= 0)
                j--;
        }

        // Already a subsequence
        if (pref[n - 1] != m)
            return true;

        for (int i = 0; i < n; i++) {

            int left = (i == 0) ? -1 : pref[i - 1];
            int right = (i == n - 1) ? m : suff[i + 1];

            if (left < right - 1)
                return true;
        }

        return false;
    }
}