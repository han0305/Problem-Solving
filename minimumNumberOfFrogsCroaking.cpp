/* Given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs, that is, multiple frogs can croak at the same time, so multiple “croak” are mixed. Return the minimum number of different frogs to finish all the croak in the given string.

A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’ sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of valid "croak" return -1. */

class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int l = croakOfFrogs.length();
        if(l%5!=0) {
            return -1;
        }
        unordered_map<char,int> umap;
        int croaking = 0;
        int stopped = 0;
        for(int i =0;i<l;i++) {
            umap[croakOfFrogs[i]]++;
            if(croakOfFrogs[i] == 'r') {
                if(umap['c'] == 0) 
                    return -1;
                else umap['c']--;
            }
            else if(croakOfFrogs[i] == 'o') {
                if(umap['r'] == 0) 
                    return -1;
                else umap['r']--;
            }
            else if(croakOfFrogs[i] == 'a') {
                if(umap['o'] == 0) 
                    return -1;
                else umap['o']--;
            }
            else if(croakOfFrogs[i] == 'c') {
                if(stopped>0) {
                    stopped--;
                }
                croaking++;
            }
            else if(croakOfFrogs[i] == 'k') {
                if(umap['a'] == 0) {
                    return -1;
                }
                umap['k']--;
                umap['a']--;
                stopped++;
                croaking--;
            }
            
        }
        for(auto i:umap) {
            if(i.second>0)
                return -1;
        }
        
        return stopped;
    }
};