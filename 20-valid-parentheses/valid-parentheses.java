class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if(stack.isEmpty()) {
                    return false;
                } 
                if(stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    /*
    public boolean isValid(String s) {
       while(s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
       }
       return s.isEmpty();
    }
    */
}