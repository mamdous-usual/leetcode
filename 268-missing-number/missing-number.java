class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int xorExpected = 0;
        for(int i=0; i<=n; i++) {
            xorExpected = xorExpected ^ i;
        }

        int xorActual = 0;
        for(int i=0; i<n; i++) {
            xorActual = xorActual ^ nums[i];
        }

        return xorExpected ^ xorActual;
    }

    /*
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n*(n+1)/2;

        int arrSum = 0;
        for(int i=0; i<n; i++) {
            arrSum += nums[i];
        }

        return expectedSum - arrSum;
    }
    */

    /*
    public int missingNumber(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            boolean found = false;

            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }
        }

        return -1;
    }
    */
}