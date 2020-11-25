/* Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string. */

class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        unordered_map<char,int> umap;
        int l = s.length();
        int res  = -1;
        for(int i=0;i<l;i++) {
            
            if(umap.find(s[i]) == umap.end()) {
                umap[s[i]] = i;
            }
            else {
                int diff = (i - umap[s[i]]) - 1;
                res = max(diff,res);
                    
            }
            
        }
        return res;
    }
};