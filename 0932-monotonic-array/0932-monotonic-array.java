class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean dec = false;
        boolean inc = false;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                dec = true;
            } else if(nums[i] > nums[i-1]) {
                inc = true;
            }

            if(dec && inc) {
                return false;
            }
        }

        return true;

    }
}