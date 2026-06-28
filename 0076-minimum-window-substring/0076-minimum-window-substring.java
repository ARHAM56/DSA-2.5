public class Solution {
    public String minWindow(String A, String B) {

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            tmap.put(B.charAt(i), tmap.getOrDefault(B.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> wmap = new HashMap<>();

        int i = 0;
        int j = 0;

        int as = -1;
        int ae = -1;
        int ansLen = Integer.MAX_VALUE;

        int matchCount = 0;

        while (j < A.length()) {

            // Acquire
            char ch = A.charAt(j);
            wmap.put(ch, wmap.getOrDefault(ch, 0) + 1);

            if (tmap.containsKey(ch) &&
                wmap.get(ch) <= tmap.get(ch)) {
                matchCount++;
            }

            j++;

            // Release
            while (matchCount == B.length()) {

                if (j - i < ansLen) {
                    ansLen = j - i;
                    as = i;
                    ae = j - 1;
                }

                char left = A.charAt(i);

                wmap.put(left, wmap.get(left) - 1);

                if (tmap.containsKey(left) &&
                    wmap.get(left) < tmap.get(left)) {
                    matchCount--;
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