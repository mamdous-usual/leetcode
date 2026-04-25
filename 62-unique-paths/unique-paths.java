class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // filliing with -1
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        return pathHelper(m-1, n-1, dp);
    }

     public int pathHelper(int m, int n, int[][] dp) {
            if(m < 0 || n < 0) return 0;
            if(dp[m][n] != -1) return dp[m][n];
            if(m == 0 || n == 0) return 1;

            int x = pathHelper(m-1, n, dp);
            int y = pathHelper(m, n-1, dp);

            dp[m][n] = x + y;

            return x + y;
   }

}