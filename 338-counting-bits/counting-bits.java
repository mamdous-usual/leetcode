class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0; // Base case: 0 has 0 set bits

        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                // i is even → last bit is 0
                // f(i) = f(i / 2)
                ans[i] = ans[i >> 1];
            } else {
                // i is odd → last bit is 1
                // f(i) = f(i / 2) + 1
                ans[i] = ans[i >> 1] + 1;
            }
        }

        return ans;
    }



    /*
    public int[] countBits(int n) {
       int[] ans = new int[n+1];

        for(int i=0; i<=n; i++) {
            ans[i] = hammingWeight(i);
        }

        return ans;
    }

    private int hammingWeight(int n) {
        int count = 0;

        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count++;
    }
    */
}