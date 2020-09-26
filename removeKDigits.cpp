/* Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero. */
class Solution {
public:
    string removeKdigits(string num, int k) {
        
        int l = num.length();
        if(l == k)
            return "0";
        
        stack<char> st;
        
        for(int i=0;i<l;i++) {
            while(!st.empty() && k>0 && num[i]<st.top()){
                st.pop();
                k--;
            }
            st.push(num[i]);
        }
        for(int i=1;i<=k;i++) {
            st.pop();
        }
        
        string res ="";
        while(!st.empty()) {
            res = string(1,st.top()) + res;
            st.pop();
        }
        int i=0;
        l = res.length();
        while(i<l && res[i] == '0') {
            i++;
        }
        res = res.substr(i,l-i);
        return res == ""?"0":res;
    }
};