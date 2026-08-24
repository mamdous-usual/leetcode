import java.util.Arrays;

class Solution {

    // idea: instead of 2 separate paths, move both people at the same time,
    // step by step. after t steps, row+col = t always (since each move is
    // either +1 row or +1 col). so if I know r1, c1, r2, I can figure out c2
    // for free -> c2 = (r1+c1) - r2. that's why I only need a 3D dp instead of 4D.
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        // dp[r1][c1][r2] -> best cherries so far when p1 is at (r1,c1) and
        // p2 is at (r2, c2), c2 computed on the fly as t - r2
        int[][][] dp = new int[n][n][n];

        // using MIN_VALUE as "not reachable" since 0 cherries is a valid state
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);

        // both start at (0,0), t=0. only valid if it's not a thorn
        if (grid[0][0] != -1) {
            dp[0][0][0] = grid[0][0];
        }

        // go step by step (t = total steps taken = r1+c1). has to be in this
        // order because every move increases t by 1, so t-1 states need to
        // already be done before we get to t
        for (int t = 1; t <= 2 * (n - 1); t++) {

            // r1 can't go so low that c1 = t-r1 overflows n, and can't go
            // so high that c1 goes negative -> clamps the range
            int lo = Math.max(0, t - n + 1);
            int hi = Math.min(n - 1, t);

            for (int r1 = lo; r1 <= hi; r1++) {
                int c1 = t - r1;

                // dead cell or off grid, skip
                if (c1 < 0 || c1 >= n || grid[r1][c1] == -1) continue;

                // only need r2 >= r1, doesn't matter who's "person 1" or
                // "person 2" since they collect the same cherries either way
                for (int r2 = r1; r2 <= hi; r2++) {
                    int c2 = t - r2;

                    if (c2 < 0 || c2 >= n || grid[r2][c2] == -1) continue;

                    // 4 ways to get here - each person either came from
                    // above or from the left on the last step
                    int bothFromUp   = get(dp, r1 - 1, c1, r2 - 1, n);
                    int p1UpP2Left   = get(dp, r1 - 1, c1, r2, n);
                    int p1LeftP2Up   = get(dp, r1, c1 - 1, r2 - 1, n);
                    int bothFromLeft = get(dp, r1, c1 - 1, r2, n);

                    int best = Math.max(
                        Math.max(bothFromUp, p1UpP2Left),
                        Math.max(p1LeftP2Up, bothFromLeft)
                    );

                    // none of the 4 previous states were reachable -> this
                    // state isn't reachable either, leave as MIN_VALUE
                    if (best == Integer.MIN_VALUE) continue;

                    // add cherries from current cells. if both people are on
                    // the same square, only count it once
                    int cherries = grid[r1][c1] + (r1 == r2 ? 0 : grid[r2][c2]);

                    dp[r1][c1][r2] = best + cherries;
                }
            }
        }

        // answer = both people ending up at bottom right at the same time
        int ans = dp[n - 1][n - 1][n - 1];
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    // just a helper so I don't have to write the bounds check 4 times above,
    // returns MIN_VALUE for anything out of range instead of throwing
    private int get(int[][][] dp, int r1, int c1, int r2, int n) {
        if (r1 < 0 || c1 < 0 || r2 < 0 || r1 >= n || c1 >= n || r2 >= n) {
            return Integer.MIN_VALUE;
        }
        return dp[r1][c1][r2];
    }
}