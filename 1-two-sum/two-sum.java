class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int targetNum = target - nums[i];
            if(map.containsKey(targetNum)) {
                return new int[]{map.get(targetNum),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1, -1};

    }

/*
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length - 1; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) return new int[] {i,j};
            }
        }

        return new int[] {0,0};
    }

*/














    /*
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length - 1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    */
}