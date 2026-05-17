class Solution {

    public int countKthRoots(int l, int r, int k) {

        long a = ceil(l, k);
        long b = floor(r, k);

        return a > b ? 0 : (int)(b - a + 1);
    }

    private long floor(long n, int k) {

        long lo = 1, hi = n, ans = 0;

        while (lo <= hi) {

            long m = lo + (hi - lo) / 2;

            if (pow(m, k, n) <= n) {
                ans = m;
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }

        return ans;
    }

    private long ceil(long n, int k) {

        long lo = 1, hi = n, ans = n;

        while (lo <= hi) {

            long m = lo + (hi - lo) / 2;

            if (pow(m, k, n) >= n) {
                ans = m;
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }

        return ans;
    }

    private long pow(long b, int e, long lim) {

        long res = 1;

        for (int i = 0; i < e; i++) {

            if (res > lim / b) {
                return lim + 1;
            }

            res *= b;
        }

        return res;
    }
}