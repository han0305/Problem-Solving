/* You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s. */

class Solution {
    public int maximumGain(String s, int x, int y) {
        char first = x>y?'a':'b';
        char second = x>y?'b':'a';
        int bigger = x>y?x:y;
        int smaller = x<y?x:y;
        ArrayDeque<Character> st = new ArrayDeque();
        int total = 0;
        for(int i=0;i<s.length();i++) {
            
            if(!st.isEmpty() && st.peek() == first && s.charAt(i) == second) {
                st.pop();
                total+=bigger;
            }
            else {
                st.push(s.charAt(i));
            }
        }
        ArrayDeque<Character> st1 = new ArrayDeque();
        while(!st.isEmpty()) {
            char curr = st.pop();
            if(!st1.isEmpty() && st1.peek() == first && curr == second) {
                st1.pop();
                total+=smaller;
            }
            else {
                st1.push(curr);
            }
        }
        return total;
    }
}