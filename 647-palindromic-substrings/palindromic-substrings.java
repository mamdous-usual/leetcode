class Solution {
    public int countSubstrings(String s) {
       int count = 0;

       for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                String substring = s.substring(i,j+1);

                if(isPalindrome(substring)) {
                    count++;
                }
            }
       }

       return count;
    }

    private boolean isPalindrome(String substring) {
        if(substring.length() <= 1) return true;
        int left = 0;
        int right = substring.length() - 1;

        while(left < right) {
            if(substring.charAt(left) != substring.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}