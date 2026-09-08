class Solution {
    public String minWindow(String s, String t) {
       Map<Character, Integer> freqT = new HashMap<>();
       for(char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c,0) + 1);
       }

       int remaining = freqT.size();
       int left = 0;
       int minStart = 0;
       int minLength = Integer.MAX_VALUE;

       for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if(freqT.containsKey(ch)) {
                freqT.put(ch,freqT.get(ch) - 1);
                if(freqT.get(ch) == 0) {
                    remaining--;
                }
            }

            while(remaining == 0) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if(freqT.containsKey(leftChar)) {
                    freqT.put(leftChar, freqT.get(leftChar) + 1);
                    if(freqT.get(leftChar) > 0) {
                        remaining++;
                    }
                }
                left++;
            }
       }

       return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}