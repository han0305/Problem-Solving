/* From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1. */

class Solution {
public:
    int shortestWay(string source, string target) {
        
        vector<int> freq(26,0);
        //vector<int> targetFreq(26,0);
        vector<int> firstOcc(26,-1);
        //unordered_map<int,vector<int>> freqAfter;
        unordered_map<int,vector<int>> occAfter;
        int l = source.length();
        for(int i=l-1;i>=0;i--) {
          //  umap[i].push_back(freq);
            occAfter[i] = firstOcc;
            firstOcc[source[i]-'a'] = i;
            freq[source[i]-'a']++;
        }
        int minCount = 1;
        int tl = target.length();
        int sourceIndex = 0;
        for(int i=0;i<tl;i++) {
            if(freq[target[i]-'a'] == 0) {
                return -1;
            }
            if(source[sourceIndex] != target[i] ) {
                
                if(occAfter[sourceIndex][target[i]-'a'] != -1) {
                    sourceIndex = occAfter[sourceIndex][target[i]-'a'] +1;
                }
                else {
                    sourceIndex = firstOcc[target[i]-'a']+1;
                    minCount++;
                }
                
            }
            else {
                
                sourceIndex++;
            }
            if(sourceIndex == l && i<tl-1) {
                sourceIndex = 0;
                minCount++;
            }
        }
        
        return minCount;
    }
};