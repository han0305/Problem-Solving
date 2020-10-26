/* Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000. */

class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        
        int l = s.length();
        bool isPossible = false;
        for(int i = 0;i<l/2;i++) {
            string sub = s.substr(0,i+1);
            string newString = "";
            while(newString.length()<=s.length()) {
                
                newString+=sub;
                if(s == newString) {
                    isPossible = true;
                    break;
                }
                
            }
            if(isPossible) {
                break;
            }
            
            
        }
        return isPossible;
    }
};