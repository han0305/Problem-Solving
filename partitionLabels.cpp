/* A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts. */

class Solution {
public:
    vector<int> partitionLabels(string s) {
       int a[26];
    vector<int> res;
        for(int i = 0;i<s.length();i++) {
            
            a[s[i]-'a'] = i;
        }
       int i = 0;
        while(i<s.length()) {
         int start = i;
         int end = a[s[i]-'a'];
            while(i<end) {
                if(a[s[i]-'a']>end) {
                    end = a[s[i]-'a'];
                }
                i++;
            }
            int length = end-start+1;
            res.push_back(length);
            i = end+1;
        }
       return res; 
    }
};