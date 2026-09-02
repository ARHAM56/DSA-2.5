class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean even = false;
        boolean odd = false;

        for (int i = 0; i < nums1.length; i++) {

            if (nums1[i] % 2 == 0)
                even = true;
            else
                odd = true;
        }

        if (even && !odd || odd && !even)
            return true;

        return true;
    }
}