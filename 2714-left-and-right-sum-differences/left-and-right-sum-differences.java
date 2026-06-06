class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        int[] arr = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
         for(int i = nums.length - 1; i >= 0; i--){
            arr1[i] = sum - nums[i];
            sum = sum - nums[i];
        }
         for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

         for(int i = 0; i < nums.length; i++){
            arr2[i] = sum - nums[i];
            sum = sum - nums[i];
        }
        
        for(int i = 0; i < nums.length; i++){
            arr[i] = Math.abs(arr1[i] - arr2[i]);
        }
        return arr;
    }
}