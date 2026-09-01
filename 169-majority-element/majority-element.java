class Solution {
    public int majorityElement(int[] nums) {
       Map<Integer, Integer> ans = new HashMap<>();

       for(int i=0; i<nums.length; i++) {
            ans.put(nums[i], ans.getOrDefault(nums[i], 0) + 1);

            if(ans.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
       }

       return -1;
    }
}