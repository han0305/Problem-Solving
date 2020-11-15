/* Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there will be only one word. */

class Solution {
public:
    vector<string> printVertically(string s) {
        int l = s.length();
        vector<string> words;
        int i = 0;
        string currWord = "";
        int maxLen = 0;
        while(i<l) {
            
            if(s[i]!=' ') {
                currWord+=string(1,s[i]);
            }
            if(s[i] == ' ' || i==l-1) {
                int currLen = currWord.length();
                maxLen = max(maxLen,currLen);
                words.push_back(currWord);
                currWord = "";
            }
            i++;
        }
        
        vector<string> res(maxLen,"");
        l = words.size();
        
        for(i=l-1;i>=0;i--) {
           
            currWord = words[i];
            int currLen = currWord.size();
            for(int j=0;j<maxLen;j++) {
                if(j<currLen) {
                    res[j]=string(1,currWord[j]) + res[j];
                }
                else if(res[j].length()>0) {
                    
                        res[j]=" "+res[j];
                }
            }
            
        }
        
       return res; 
    }
};