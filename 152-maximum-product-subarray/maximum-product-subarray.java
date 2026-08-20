class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for(int i=1; i<nums.length; i++) {
            int current = nums[i];

            int tempMaxSoFar = Math.max(current, Math.max(current * maxSoFar, current * minSoFar));
            int tempMinSoFar = Math.min(current, Math.min(current * maxSoFar, current * minSoFar));

            maxSoFar = tempMaxSoFar;
            minSoFar = tempMinSoFar;

            maxProduct = Math.max(maxSoFar, maxProduct);
        }

        return maxProduct;
    }

    /*
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
    */
}