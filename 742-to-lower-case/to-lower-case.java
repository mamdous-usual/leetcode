class Solution {
    public String toLowerCase(String s) {
        char[] ch = s.toCharArray();

        for(int i=0; i<ch.length; i++) {
            if(ch[i] >= 65 && ch[i] <= 90) { // 'A' -> 65 'z' -> 90
                ch[i] = (char) (ch[i] + 32);
            }
        }
        String ans = new String(ch);

        return ans;
    }
}