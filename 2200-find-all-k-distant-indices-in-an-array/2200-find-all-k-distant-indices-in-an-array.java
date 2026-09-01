class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> arr = new ArrayList<Integer>();
        boolean[] added = new boolean[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == key)
            {
                int j = 0;

                while(j < nums.length)
                {
                    if(Math.abs(j - i) <= k && !added[j])
                    {
                        arr.add(j);
                        added[j] = true;
                    }

                    j++;
                }
            }
        }

        return arr;
    }
}