class Solution {
    public int trap(int[] height) {
        int[] left=new int [height.length];
        int[] right =new int [height.length];
        int[] max_min=new int [height.length];
        int max_l=height[0];
        left[0]=max_l;
        int max_r=height[height.length-1];
        right[height.length-1]=max_r;
        for(int i=1 ; i<height.length ; i++)
        {
            if(max_l<height[i])
            {
                left[i]=height[i];
                max_l = height[i];
                

            }
            else
            {
                left[i]=max_l;
            }
        }
        for(int i=height.length-2 ; i>=0 ; i--)
        {
            if(max_r<height[i])
            {
                right[i]=height[i];
                max_r = height[i];
                

            }
            else
            {
                right[i]=max_r;
            }

        }
        int sum=0;
        for(int i=0 ; i<height.length ; i++)
        {
            max_min[i]=Math.min(left[i] , right[i]);
            sum +=max_min[i]-height[i];

            

        }
        return sum;

        
    }
}