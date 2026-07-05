class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int NEG = -(int)1e9;

    private int n;
    private List<String> board;
    private Pair[][] dp;

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        n = board.size();
        dp = new Pair[n][n];

        Pair ans = dfs(0, 0);

        return ans.score < 0
                ? new int[]{0, 0}
                : new int[]{ans.score, ans.path};
    }

    private Pair dfs(int i, int j) {
        if (i >= n || j >= n)
            return new Pair(NEG, 0);

        char ch = board.get(i).charAt(j);

        if (ch == 'X')
            return new Pair(NEG, 0);

        if (i == n - 1 && j == n - 1)
            return new Pair(0, 1);

        if (dp[i][j] != null)
            return dp[i][j];

        Pair down = dfs(i + 1, j);
        Pair right = dfs(i, j + 1);
        Pair diagonal = dfs(i + 1, j + 1);

        int best = Math.max(down.score, Math.max(right.score, diagonal.score));

        long ways = 0;
        if (down.score == best) ways += down.path;
        if (right.score == best) ways += right.path;
        if (diagonal.score == best) ways += diagonal.path;
        ways %= MOD;

        int value = Character.isDigit(ch) ? ch - '0' : 0;

        return dp[i][j] = new Pair(best + value, (int) ways);
    }

    class Pair {
        int score;
        int path;

        Pair(int score, int path) {
            this.score = score;
            this.path = path;
        }
    }
}