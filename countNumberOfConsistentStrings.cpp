/* You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

*/

class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        vector<int> freq(26,0);
        for(int i=0;i<allowed.length();i++) {
            freq[allowed[i]-'a']++;
        }
        int count = 0;
        for(int i=0;i<words.size();i++) {
            string s = words[i];
            bool isPossible = true;
            for(int j=0;j<s.length();j++) {
                if(freq[s[j]-'a'] == 0) {
                    isPossible = false;
                    break;
                    
                }
            }
            if(isPossible)
                count++;
        }
        return count;
    }
};