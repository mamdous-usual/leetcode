class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            String key = getFrequencyString(str);

            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }

            anagramGroups.get(key).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    private String getFrequencyString(String str) {
        int[] charFrequency = new int[26];

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            charFrequency[index]++;
        }

        StringBuilder frequencyStr = new StringBuilder();
        for(int i=0; i<charFrequency.length; i++) {
            if(charFrequency[i] > 0) {
                frequencyStr.append((char) 'a' + i).append(charFrequency[i]);
            }
        }

        return frequencyStr.toString();
    }
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> anagramGroups = new HashMap<>();
    
       for(int i=0; i<strs.length; i++) {
            String word = strs[i];
    
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
    
            if(!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }
    
            anagramGroups.get(key).add(word);
       }
    
       return new ArrayList<>(anagramGroups.values());
    }
    */
}