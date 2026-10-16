

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        String s = "";

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !st.isEmpty() &&
                   st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        while (!st.isEmpty()) {
            s = st.pop() + s;
        }

     
        s = s.replaceFirst("^0+", "");


        return s.isEmpty() ? "0" : s;
    }
}

