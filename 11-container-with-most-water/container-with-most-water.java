class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1; 
        int maxWater = 0;

        while(left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;
            maxWater = Math.max(maxWater, currentArea);

            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    /*

    public int maxArea(int[] height) {
        int maxWater = 0;
        int n = height.length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                
                int currentArea = width * minHeight;
                maxWater = Math.max(maxWater, currentArea);
            }
        }

        return maxWater;
    }
    */
}