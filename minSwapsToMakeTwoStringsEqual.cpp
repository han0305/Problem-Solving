/* You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].

Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so. */

class Solution {
public:
    int minimumSwap(string s1, string s2) {
        int l = s1.length();
        unordered_map<string,int> umap;
        for(int i=0;i<l;i++) {
            
            if(s1[i]!=s2[i]) {
                umap[string(1,s1[i])+string(1,s2[i])]++;
            }
        }
        int swaps = 0;
        for(auto i:umap) {
            if(i.second>0) {
                int rem = i.second%2;
                swaps+=i.second/2;
                if(rem>0) {
                    string revKey = i.first;
                    reverse(revKey.begin(),revKey.end());
                    if(umap[revKey] >= rem) {
                        umap[revKey]-=rem;
                        swaps+=2*rem;
                    }
                    else {
                        return -1;
                    }
                }
               umap[i.first] = 0; 
            }
        }
        return swaps;
    }
};