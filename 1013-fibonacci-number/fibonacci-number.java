class Solution {
    public int fib(int n) {
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);

       return fibHelper(n,dp);
    }

    static int fibHelper(int n, int[] dp) {
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1) return dp[n];

        int a = fibHelper(n-1, dp);
        int b = fibHelper(n-2, dp);
        dp[n] = a+b;
        return a+b;
    }
}