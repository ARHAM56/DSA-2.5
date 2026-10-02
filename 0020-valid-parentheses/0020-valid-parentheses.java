class Solution {

    boolean iscompatible(char ch, char peek)
    {
        if(ch == ')')
        {
            return peek == '(';
        }
        else if(ch == '}')
        {
            return peek == '{';
        }
        else
        {
            return peek == '[';
        }
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                else if(iscompatible(ch, st.peek()) == false)
                {
                    return false;
                }
                else
                {
                    st.pop();   
                }
            }
        }

        return st.isEmpty(); 
    }
}