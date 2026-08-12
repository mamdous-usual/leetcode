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

    /*
    public int[] twoSum(int[] nums, int target) {
        int[][] indexedNums = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i]; 
            indexedNums[i][1] = i;
        }

        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int currentSum = indexedNums[left][0] + indexedNums[right][0];

            if (currentSum == target) {
                return new int[] { indexedNums[left][1], indexedNums[right][1] };
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
    */
    
}