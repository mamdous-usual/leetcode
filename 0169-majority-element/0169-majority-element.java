class Solution {
    public int majorityElement(int[] nums) { // Boyer-Moore Majority voie algorithm
        int majority = nums[0];
        int vote = 1;

        for(int i=1; i<nums.length; i++) {
            if(vote == 0) {
                vote++;
                majority = nums[i];
            } else if(nums[i] == majority) {
                vote++;
            } else {
                vote--;
            }
        }

        return majority;
        
    }
    /*
    public int majorityElement(int[] nums) { // Frequency
       Map<Integer, Integer> ans = new HashMap<>();

        int n = nums.length;

        for(int num : nums) {
            ans.put(num, ans.getOrDefault(num,0) + 1);

            if(ans.get(num) > n/2) {
                return num;
            }
        }

        return -1;
    }
    */
}