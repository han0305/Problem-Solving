/* Return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once. */

class Solution {
public:
    string smallestSubsequence(string s) {
        unordered_map<int,int> umap;
        int l = s.length();
        for(int i=0;i<l;i++) {
            umap[s[i]]++;
        }
        stack<char> st;
        unordered_map<char,int> visited;
        
        for(int i=0;i<l;i++) {
            if(visited.find(s[i]) == visited.end()) {
                visited[s[i]] = 1;
                while(!st.empty() && s[i]<st.top() && umap[st.top()]>0) {
                    visited.erase(st.top());
                    st.pop();
                    
                }
                st.push(s[i]);
                
                
            }
            umap[s[i]]--;
        }
        string res;
        while(!st.empty()) {
            res = string(1,st.top())+res;
            st.pop();
        }
        return res;
    }
};