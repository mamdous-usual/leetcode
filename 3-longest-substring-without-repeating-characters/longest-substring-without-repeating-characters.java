class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }

        Set<Character> seen = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while(seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /*
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }

        int maxLength = 0;

        for(int i=0; i<s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for(int j=i; j<s.length(); j++) {
                char currentChar = s.charAt(j);

                if(seen.contains(currentChar)) {
                    break;
                }

                seen.add(currentChar);
                // maxLength = Math.max(maxLength, seen.size());
                maxLength = Math.max(maxLength, j-i+1);

            }
        }

        return maxLength;
    }
    */
}