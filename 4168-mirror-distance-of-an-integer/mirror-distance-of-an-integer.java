class Solution {
    public int mirrorDistance(int n) {
       return Math.abs(n - reverse(n)); 
    }
    static int reverse(int n){
        int reverse = 0;
        while(n != 0){
            reverse = reverse * 10 + (n%10);
            n /= 10;
        }
        return reverse;
    }
}