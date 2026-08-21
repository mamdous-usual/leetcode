class Solution {
    /*
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            Character currentChar = s.charAt(i);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            Character currentChar = t.charAt(i);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) - 1);
        }

        for(Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            Integer value = entry.getValue();

            if(value != 0) {
                return false;
            }
        }

        return true;
    }
    */

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            int sIndex = sChar - 'a';
            int tIndex = tChar - 'a';

            count[sIndex]++;
            count[tIndex]--;
        }

        for(int i=0; i<count.length; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }
    
    /*
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()){
            return false;
       }
       
       char[] sArr = s.toCharArray();
       char[] tArr = t.toCharArray();

       Arrays.sort(sArr);
       Arrays.sort(tArr);

        for(int i=0; i<sArr.length;i++) {
            if(sArr[i] != tArr[i]) {
                return false;
            }
        }

        return true;
        // return Arrays.equals(sArr, tArr);
    }
    */
}