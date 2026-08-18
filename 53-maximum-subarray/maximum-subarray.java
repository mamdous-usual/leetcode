class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i=0; i<nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum < 0) currentSum = 0;
        }

        return maxSum;
    }

    /*
    public int maxSubArray(int[] nums) {
       int maxSum = Integer.MIN_VALUE;
       for(int i=0; i<nums.length; i++) {
            int currentSum = 0;
            for(int j=i; j<nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
       }

       return maxSum;
    }
    */
}