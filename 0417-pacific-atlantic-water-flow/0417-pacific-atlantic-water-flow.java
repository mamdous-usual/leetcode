class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        int m = heights.length;
        int n = heights[0].length;

        visited[row][col] = true;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                continue;
            }

            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }
}