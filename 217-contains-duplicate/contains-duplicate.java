class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(visited.contains(nums[i])) return true;

            visited.add(nums[i]);
        }

        return false;
    }


    /*

    public boolean containsDuplicate(int[] nums) {
       for(int i=0; i<nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) return true;
            }
       } 

       return false;
    }
    */
}