class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int maxProduct = Integer.MIN_VALUE;

       for(int i=0; i<n; i++) {
            int currentProduct = 1;

            for(int j=i; j<n; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
       }

       return maxProduct;

    }
}