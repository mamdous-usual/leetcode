class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;
        // Rotate the array
        rotatePart(nums,0,n-1);

        // Rotate the array upto k
        rotatePart(nums,0,k-1);

        // Rotate the arry k to n-1
        rotatePart(nums,k,n-1);
    }

    public void rotatePart(int[] arr, int sp, int ep) {
        while(sp < ep) {
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;

            sp++;
            ep--;
        }
    }
}