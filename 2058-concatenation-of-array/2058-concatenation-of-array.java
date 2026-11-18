class Solution {
    // ans[i] = nums[i%n] -> modular arithmetic
    public int[] getConcatenation(int[] nums) {
        int n = nums.length; 
        int[] ans = new int[n*2];

        for(int i=0; i<ans.length; i++) {
            ans[i] = nums[i%n]; 
        }

        return ans;
    }
    /*
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n*2];

        for(int i=0; i<n; i++) {
            ans[i] = nums[i];
        }
        for(int i=0; i<n; i++) {
            ans[i + n] = nums[i];
        }

        return ans;
    }
    */
}