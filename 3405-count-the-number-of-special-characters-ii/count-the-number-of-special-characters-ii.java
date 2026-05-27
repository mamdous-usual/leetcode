// Added using AI
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] first = new int[26];
        int[] second = new int[26];
        Arrays.fill(first, -1) ;
        Arrays.fill(second, -1);
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char a = word.charAt(i);
            if (Character.isLowerCase(a)) {
                first[a - 'a'] = i ;
            } else {
                int index = (int) a - 'A';
                if (second[index] == -1)
                    second[index] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && second[i] != -1 && first[i] < second[i])
                ans++ ;
        }
        return ans;
    }
}