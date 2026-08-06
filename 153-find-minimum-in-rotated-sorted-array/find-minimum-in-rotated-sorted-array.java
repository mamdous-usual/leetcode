class Solution {
    public int findMin(int[] nums) {
        if(nums.length <=1) {
            return nums[0];
        }

        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) 
                return nums[i+1];
        }

        return nums[0];
    }

    /*
    public int findMin(int[] nums) {
       int minVal = Integer.MAX_VALUE;

       for(int i=0; i<nums.length; i++) {
            if(nums[i] < minVal) minVal = nums[i];
       } 

       return minVal;
    }
    */
}