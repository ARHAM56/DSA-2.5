class Solution {
    public boolean is_possible(int[] arr , int mid  , int h)
    {
        long height=0;
        for(int i=0 ; i<arr.length ; i++)
        {
            height += (arr[i] + mid-1)/mid;
            if(height > h)
            {
                return false;

            }
            

        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int s=1;
        int e=0;
        int ans=0;
        for(int i=0; i< n ; i++)
        {
            e= Math.max(piles[i] , e);
        }
        while(s<=e)
        {
            int mid= (s+e)/2;
            if(is_possible(piles , mid , h))
            {
                ans=mid;
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }

        }
        return ans;
        
    }
}