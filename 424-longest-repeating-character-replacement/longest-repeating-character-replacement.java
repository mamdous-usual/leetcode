class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFrequency = new int[26];

        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            int charIndex = currentChar - 'A';
            charFrequency[charIndex]++;

            maxFrequency = Math.max(maxFrequency, charFrequency[charIndex]);

            int windowLength = right - left + 1;
            int charToChange = windowLength - maxFrequency;

            while (charToChange > k) {
                char leftChar = s.charAt(left);
                int leftCharIndex = leftChar - 'A';
                charFrequency[leftCharIndex]--;
                left++;

                windowLength = right - left + 1;
                charToChange = windowLength - maxFrequency;
            }

            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }
}