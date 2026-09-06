class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int longestPalindromeLength = 0;
        int longestPalindromeStart = 0;

        for(int i=0; i<s.length(); i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            int oddCenterPalindromeLength = right - left - 1;

            left = i;
            right = i+1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            int evenCenterPalindromeLength = right - left - 1;

            int currentMaxLength = Math.max(oddCenterPalindromeLength, evenCenterPalindromeLength);

            if(currentMaxLength > longestPalindromeLength) {
                longestPalindromeLength = currentMaxLength;
                longestPalindromeStart = i - (currentMaxLength - 1) / 2; // calculate start position(formula)
            }

        }

        return s.substring(longestPalindromeStart, longestPalindromeStart+longestPalindromeLength);
    }
    
    /*
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            //odd
            int left = i, right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                String currentPalindrome = s.substring(left, right + 1);
                int length = currentPalindrome.length();
                if (length > longest.length()) {
                    longest = currentPalindrome;
                }
                left--;
                right++;
            }

            // even
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                String currentPalindrome = s.substring(left, right + 1);
                int length = currentPalindrome.length();
                if (length > longest.length()) {
                    longest = currentPalindrome;
                }
                left--;
                right++;
            }
        }

        return longest;
    }
    */
}