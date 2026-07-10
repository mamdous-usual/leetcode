class Solution {
    public boolean isGoodArray(int[] nums) {
        int ans = Math.abs(nums[0]);

        for(int i=0; i<nums.length; i++) {
            ans = gcd(ans, Math.abs(nums[i]));
        }

        return ans == 1;
    }

    int gcd(int a, int b) {
        if(a == 0) return b;
        
        int temp = gcd(b%a, a);
        return temp;
    }
}