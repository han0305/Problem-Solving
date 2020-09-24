/* You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.

You are also given an integer maxCost.

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.

If there is no substring from s that can be changed to its corresponding substring from t, return 0. */

class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int l = s.length();
        int j=0;
        int maxLen = 0;
        int currCost = 0;
        
        for(int i=0;i<l;i++) {
                currCost+=abs(s[i]-t[i]);
                if(currCost > maxCost) {
                    currCost -=abs(s[j]-t[j]);
                    j++;
                }
                
                if(currCost<=maxCost) {
                    maxLen = max(maxLen,i-j+1);
                    
                }
            
            
        }
        return maxLen;
    }
};