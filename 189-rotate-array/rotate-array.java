class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        rotatePart(nums, 0, n - 1); // Reverse the whole array
        rotatePart(nums, 0, k-1); // Reverse the first k elements
        rotatePart(nums, k, n - 1); // Reverse the elements after k elements

    }

    static void rotatePart(int[] nums, int idx1, int idx2) {
        while(idx1 < idx2) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            idx1++;
            idx2--;
        }
    }

    /*
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            res[(i+k) % len] = nums[i];
        }
        for(int i=0; i<len; i++) {
            nums[i] = res[i];
        }
    }
    */

}