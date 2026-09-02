class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();

        for (int num : nums) {
            ans.put(num, ans.getOrDefault(num, 0) + 1);
            
            if (ans.get(num) > nums.length / 2) 
                return num;
        }
        return -1;
    }
}