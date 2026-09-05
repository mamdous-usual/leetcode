class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversedStr = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversedStr);
    }
}