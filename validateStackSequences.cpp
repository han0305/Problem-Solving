class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int l = pushed.size();
        int j = 0;
        stack<int> st;
        
        for(int i=0;i<l;i++) {
            st.push(pushed[i]);
            while(!st.empty() && st.top() == popped[j]) {
                
                st.pop();
                j++;
            }
        }
        
        return j==l;
    }
};