class Solution {
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
}