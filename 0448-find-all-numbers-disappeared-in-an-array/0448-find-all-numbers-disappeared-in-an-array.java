class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();        
        
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] < 0) {
                continue;
            }

            nums[idx] *= -1;
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }

        return ans;
    }

    /*
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> ans = new ArrayList<>();
        int n = nums.length;

       for(int i=1; i<=n; i++) {
            boolean found = false;
            for(int j=0; j<n; j++) {
                if(nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                ans.add(i);
            }
       }

       return ans;
    }
    */
}