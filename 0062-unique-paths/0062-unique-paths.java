class Solution {
    public int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int k = Math.min(m - 1, n - 1);

        long result = 1;

        for (int i = 0; i < k; i++) {
            result = result * (totalMoves - i) / (i + 1);
        }

        return (int) result;
    }
}