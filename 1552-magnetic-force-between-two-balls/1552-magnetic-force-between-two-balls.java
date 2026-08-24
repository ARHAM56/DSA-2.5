class Solution {
    public boolean is_possible(int[] arr , int mid , int k)
    {
        int bolls=1;
        int current=arr[0];
        for(int i=1; i<arr.length ; i++)
        {
            if(arr[i]-current >= mid)
            {
                bolls++;
                current=arr[i];
            }
            if(bolls==k)
            {
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length -1;

        int s=1;
        int e=position[n]-position[0];
        int ans=0;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(is_possible(position , mid , m ))
            {
                ans=mid;
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
            

        }
        return ans;
    }
}