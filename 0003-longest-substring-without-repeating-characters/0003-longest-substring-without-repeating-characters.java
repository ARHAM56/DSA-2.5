class Solution {
    public int lengthOfLongestSubstring(String s) {

        boolean[] freq = new boolean[256];

        int i = 0;
        int j = 0;
        int max_size = 0;

        while (j < s.length()) {

            // Duplicate found
            while (freq[s.charAt(j)]) {
                freq[s.charAt(i)] = false;
                i++;
            }

            // Add current character
            freq[s.charAt(j)] = true;

            // Calculate window length
            max_size = Math.max(max_size, j - i + 1);

            j++;
        }

        return max_size;
    }
}