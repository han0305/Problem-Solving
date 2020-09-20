/* Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string. */

class Solution {
public:
    void backtrack(string s,unordered_map<string,int>& seen,int curr,int n,int& count,int& maxm) {
        if(curr >= n) {
            maxm = max(maxm,count);
            return;
        }
        
        for(int len = 1;len<=n-curr+1;len++) {
            string temp = s.substr(curr,len);
            if(seen.find(temp) == seen.end()) {
                seen[temp] = 1;
                count++;
                backtrack(s,seen,curr+len,n,count,maxm);
                count--;
                seen.erase(temp);
            }
            
        }
        
    }
    int maxUniqueSplit(string s) {
        unordered_map<string,int> seen;
        int l = s.length();
        int count = 0;
        int maxm =INT_MIN;
        backtrack(s,seen,0,l,count,maxm);
        return maxm;
        
    }
};