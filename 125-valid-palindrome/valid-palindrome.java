class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) 
            return true;

        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /*
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversedStr);
    }
    */
    
}