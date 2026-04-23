class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        } 

        return pathHelper(m-1, n-1, obstacleGrid, dp);
    }

    public int pathHelper(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int x = pathHelper(i-1, j, obstacleGrid, dp);
        int y = pathHelper(i, j-1, obstacleGrid, dp);

        dp[i][j] = x + y;

        return x + y;
    }
}