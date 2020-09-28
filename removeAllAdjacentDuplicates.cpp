/* Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique. */

class Solution {
public:
    string removeDuplicates(string S) {
        stack<char> st;
        int l = S.length();
      
        for(int i=0;i<l;i++) {
            
            if(!st.empty() && st.top() == S[i])
            while(!st.empty() && st.top() == S[i]) {
                st.pop();
            }
            else 
                st.push(S[i]);
            
        }
        
        string res = "";
        while(!st.empty()) {
            res = string(1,st.top())+res;
            st.pop();
            
        }
        return res;
    }
};