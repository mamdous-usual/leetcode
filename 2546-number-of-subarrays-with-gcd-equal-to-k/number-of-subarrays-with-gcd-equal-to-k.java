class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int sp = 0; sp<n; sp++) {
            int ans = 0;
            for(int ep=sp; ep<n; ep++) {
                ans = gcd(ans, nums[ep]);
                if(ans < k) break;
                if(ans == k) count++;
            }
        }

        return count;
    }

    int gcd(int a, int b) {
        if(a == 0) return b;

        int temp = gcd(b%a, a);

        return temp;
    }
}