/* Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid. */

class Solution {
    public boolean checkValidString(String s) {
        
        Deque<Character> st = new ArrayDeque<Character>();
        int wc = 0;
        for(int i=0;i<s.length();i++) {
            
            if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' &&  !st.isEmpty() && st.peek() == '(') {
                st.pop();
            }
            else if(s.charAt(i) == ')' && wc>0) {
                wc--;
            }
            else if(s.charAt(i) == ')' && wc == 0) {
                return false;
            }
            else {
                if(!st.isEmpty()){
                wc++;
                st.pop();
                }
                wc++;
            }
            
        }
        return st.isEmpty();
        
    }
}