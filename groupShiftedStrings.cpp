/* Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz" Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence. */

class Solution {
public:
    string getKey(string s) {
        
        string key = "#";
        int l = s.length();
        for(int i=1;i<l;i++) {
            
            key+=to_string((s[i]+26-s[i-1])%26)+"#";
        }
        return key;
    }
    
    vector<vector<string>> groupStrings(vector<string>& strings) {
        
        int l = strings.size();
        unordered_map<string,vector<string>> umap;
        for(int i=0;i<l;i++) {
            string key = getKey(strings[i]);
            umap[key].push_back(strings[i]);
        }
        vector<vector<string>> res;
        for(auto i:umap) {
            res.push_back(i.second);
        }
        return res;
    }
};