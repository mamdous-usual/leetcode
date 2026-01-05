class Solution {
    public int trailingZeroes(int n) {
        int zeros = 0;
        for (int i=5; i<=n; i*=5){
            zeros = zeros + n/i;
        }
        return zeros;
    }
}