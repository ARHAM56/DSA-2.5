class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean [] freq=new boolean[256];

        int i=0 , j=0 ;
        int max_size=0;
        
        while(j<s.length())
        {


            while (freq[s.charAt(j)]) {
                freq[s.charAt(i)] = false;
                i++;
            }


 
            



            freq[s.charAt(j)]=true;
            max_size=Math.max(max_size , j - i + 1);
            j++;
        }
        return max_size;
        
    }
}