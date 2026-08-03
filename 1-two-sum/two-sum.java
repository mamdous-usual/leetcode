class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            if(numToIndex.containsKey(complement)) {
                return new int[] {numToIndex.get(complement),i};
            }

            numToIndex.put(nums[i], i);
        }

        return new int[] {};
    }



    /*
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }

        return new int[] {};
    }
    */
}