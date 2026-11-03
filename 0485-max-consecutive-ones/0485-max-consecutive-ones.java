class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0;

        for(int num : nums) {
            if(num == 0) {
                ans = Math.max(ans, count);
                count = 0;
            } else {
                count++;
            }
        }

        return Math.max(ans, count);
    }

    /*

    public int findMaxConsecutiveOnes(int[] nums) {
       int ans = 0;

       for(int i=0; i<nums.length; i++)  {
            int count = 0;

            for(int j=i; j<nums.length; j++) {
                if(nums[j] == 0) {
                    break;
                }
                count++;
            }

            ans = Math.max(count, ans);
       }

       return ans;
    }
    */
}