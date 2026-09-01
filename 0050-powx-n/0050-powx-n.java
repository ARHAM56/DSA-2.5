class Solution {
    public double myPow(double x, long n) {

        if(n == 0)
        {
            return 1;
        }

        if(n < 0)
        {
            return 1 / myPow(x, -n);
        }

        double ans = myPow(x, n / 2);

        if(n % 2 == 0)
        {
            return ans * ans;
        }
        else
        {
            return ans * ans * x;
        }
    }
}