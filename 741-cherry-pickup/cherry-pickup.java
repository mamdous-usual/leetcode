class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // start from bottom-right since you're moving backwards
        int ans = pickupHelper(n-1, m-1, n-1, grid, new Integer[n][m][n]);

        if(ans == Integer.MIN_VALUE) {
            return 0;
        } else {
            return ans;
        }
    }

    public int pickupHelper(int row1, int col1, int row2, int[][] grid, Integer[][][] dp) {
        int col2 = row1 + col1 - row2;

        // ✅ fix 1: correct bounds + obstacle check
        if(row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0 ||
           row1 >= grid.length || row2 >= grid.length ||
           col1 >= grid[0].length || col2 >= grid[0].length ||
           grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            return Integer.MIN_VALUE;
        }

        // base case
        if(row1 == 0 && col1 == 0 && row2 == 0 && col2 == 0) {
            return grid[0][0];
        }

        if(dp[row1][col1][row2] != null) {
            return dp[row1][col1][row2];
        }

        int temp1 = pickupHelper(row1, col1-1, row2, grid, dp);
        int temp2 = pickupHelper(row1-1, col1, row2-1, grid, dp);
        int temp3 = pickupHelper(row1, col1-1, row2-1, grid, dp);
        int temp4 = pickupHelper(row1-1, col1, row2, grid, dp);

        int ans = Math.max(Math.max(temp1, temp2), Math.max(temp3, temp4));

        // ✅ fix 2: handle all invalid paths
        if(ans == Integer.MIN_VALUE) {
            return dp[row1][col1][row2] = Integer.MIN_VALUE;
        }

        int contri;
        if(row1 == row2 && col1 == col2) {
            contri = grid[row1][col1];
        } else {
            contri = grid[row1][col1] + grid[row2][col2];
        }

        return dp[row1][col1][row2] = ans + contri;
    }
}