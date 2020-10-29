/* Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
*/

class Solution {
public:
    int scoreOfParentheses(string s) {
        
        stack<int> st;
        int l = s.length();
        int res = 0;
        for(int i=0;i<l;i++) {
            
            if(s[i] == '(') {
                st.push(0);
            }
            else {
                int score = st.top();
                st.pop();
                if(st.empty()) {
                    res+=max(1,score);
                }
                else {
                    int topScore = st.top();
                    st.pop();
                    topScore+=2*max(1,score);
                    st.push(topScore);
                }
            }
            
        }
        return res;
    }
};