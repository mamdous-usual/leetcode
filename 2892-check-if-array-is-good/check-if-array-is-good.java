class Solution {
    public boolean isGood(int[] nums) {
         int n = nums.length;
        int c = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(nums[i] == n - 1) {
                c++;
                if(c > 2) {
                    return false;
                }
                set.add(nums[i]);
            }
            else if(nums[i] >= 1 && nums[i] < n - 1) {
                set.add(nums[i]);
            }
            else {
                return false;
            }
        }

        return set.size() == n - 1 && c == 2;
    }
}