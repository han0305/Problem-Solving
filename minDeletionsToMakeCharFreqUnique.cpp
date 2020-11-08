/* A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1. */

class Solution {
public:
    int minDeletions(string s) {
        vector<int> freq(26,0);
        int l = s.length();
        for(int i=0;i<l;i++) {
            freq[s[i]-'a']++;
        }
        unordered_map<int,int> umap;
        int delCount = 0;
        for(int i=0;i<26;i++) {
            if(umap.find(freq[i]) == umap.end()) {
                umap[freq[i]] = 1;
            }
            else {
                int currFreq = freq[i];
                while(currFreq>0 && umap.find(currFreq)!=umap.end()) {
                    currFreq--;
                    delCount++;
                } 
                if(currFreq>0) {
                    umap[currFreq] = 1;
                }
            }
            
        }
        return delCount;
            
    }
};