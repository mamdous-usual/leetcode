class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        return pathHelper(m-1, n-1, grid, dp);
    }

    public int pathHelper(int i, int j, int[][] grid, int[][] dp) {
        if(i<0 || j < 0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == 0 && j == 0) return grid[0][0];
       
        int x = pathHelper(i-1, j, grid, dp);
        int y = pathHelper(i, j-1, grid, dp);

        dp[i][j] = Math.min(x,y) + grid[i][j];

        return Math.min(x,y) + grid[i][j];
    }
}