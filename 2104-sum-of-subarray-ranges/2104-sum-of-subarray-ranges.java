import java.util.Stack;

class Solution {

    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    public long sumMax(int[] arr) {
        int n = arr.length;

        int[] pge = new int[n];
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

       
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            total += left * right * arr[i];
        }

        return total;
    }

    public long sumMin(int[] arr) {
        int n = arr.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

     
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();


        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total += left * right * arr[i];
        }

        return total;
    }
}