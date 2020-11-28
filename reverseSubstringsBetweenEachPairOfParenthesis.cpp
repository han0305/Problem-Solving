/* You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets. */

class Solution {
public:
    string reverseParentheses(string s) {
        int l = s.length();
        vector<vector<int>> pos;
        stack<int> st;
        for(int i=0;i<l;i++) {
            if(s[i] == '(') {
                st.push(i);
            }
            else if(s[i] == ')'){
                int j = st.top();
                st.pop();
                pos.push_back({j,i});
            }
        }
        for(int i=0;i<pos.size();i++) {
            int start = pos[i][0];
            int end = pos[i][1];
            reverse(s.begin()+start+1,s.begin()+end);
        }
        string res = "";
        for(int i=0;i<s.length();i++) {
            if(s[i]!='(' && s[i]!=')')
                res+=string(1,s[i]);
        }
        return res;
    }
};