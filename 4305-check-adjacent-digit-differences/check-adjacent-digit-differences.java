class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        char[] ch = s.toCharArray();

        for(int i=0; i<ch.length - 1; i++) {
            int diff= Math.abs(ch[i] - ch[i+1]);

            if(diff > 2) {
                return false;
            }
        }

        return true;
    }
}