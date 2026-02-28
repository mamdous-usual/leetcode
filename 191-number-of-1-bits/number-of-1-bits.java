class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        
        while(n!=0){
            int lastBit = n & 1;
            if (lastBit == 1)
                result++;
            n = n >> 1;
        }
        return result;
    }
}