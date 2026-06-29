import java.util.Arrays;

class Solution {

    int[] storage = new int[31];

    public int fib(int n) {

        Arrays.fill(storage, -1);

        if (n == 0 || n == 1) {
            return n;
        }

        if (storage[n] != -1) {
            return storage[n];
        }

        int ans = fib(n - 1) + fib(n - 2);
        storage[n] = ans;

        return ans;
    }
}