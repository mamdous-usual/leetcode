class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // Find the smallest and largest numbers in one pass
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Return the GCD of just those two numbers
        return gcd(min, max);
    }

    // Euclidean algorithm for GCD
    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}