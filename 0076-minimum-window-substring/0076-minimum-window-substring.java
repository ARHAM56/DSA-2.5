class Solution {
    public String minWindow(String A, String B) {

        // Create frequency map of B
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            int f = tmap.getOrDefault(B.charAt(i), 0);
            tmap.put(B.charAt(i), f + 1);
        }

        HashMap<Character, Integer> wmap = new HashMap<>();

        int i = 0;
        int j = 0;

        int as = -1;
        int ae = -1;
        int anslen = Integer.MAX_VALUE;

        int match_count = 0;

        while (j < A.length()) {

            // Acquire
            while (j < A.length() && match_count < B.length()) {

                char ch = A.charAt(j);

                int f = wmap.getOrDefault(ch, 0);
                wmap.put(ch, f + 1);

                if (tmap.containsKey(ch) &&
                    wmap.get(ch) <= tmap.get(ch)) {
                    match_count++;
                }

                j++;
            }

            // Release
            while (i < j && match_count == B.length()) {

                int len = j - i;

                if (len < anslen) {
                    anslen = len;
                    as = i;
                    ae = j - 1;
                }

                char ch = A.charAt(i);

                int f = wmap.get(ch);
                wmap.put(ch, f - 1);

                if (tmap.containsKey(ch) &&
                    wmap.get(ch) < tmap.get(ch)) {
                    match_count--;
                }

                i++;
            }
        }

        if (as == -1) {
            return "";
        }

        return A.substring(as, ae + 1);
    }
}