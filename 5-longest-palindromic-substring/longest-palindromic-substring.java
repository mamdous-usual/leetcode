class Solution {
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
}