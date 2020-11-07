/* Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering. */

class Solution {
public:
    int minSteps(string s, string t) {
        vector<int> sFreq(26,0);
        vector<int> tFreq(26,0);
        int l = s.length();
        
        for(int i=0;i<l;i++) {
            sFreq[s[i]-'a']++;
            tFreq[t[i]-'a']++;
        }
        
        int diff = 0;
       for(int i=0;i<26;i++) {
           if(tFreq[i]>sFreq[i]) {
               diff+=tFreq[i]-sFreq[i];
           }
       }
       return diff;
    }
};