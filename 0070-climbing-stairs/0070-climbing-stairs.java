class Solution {
    int[] storage = new int[46];
    public int climbStairs(int n) {

        
        if (storage[0] == 0) {
            Arrays.fill(storage, -1);
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (storage[n] != -1) {
            return storage[n];
        }

        int ans = climbStairs(n - 1) + climbStairs(n - 2);
        storage[n] = ans;

        return ans;
        
    }
}

