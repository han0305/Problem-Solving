/* Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c. */

class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int l = s.length();
        vector<int> freq(3,0);
        int j=0;
        int count = 0;
        for(int i=0;i<l;i++) {
            freq[s[i]-'a']++;
            
            while(freq[0]>0 && freq[1]>0 && freq[2]>0) {
                freq[s[j]-'a']--;
                j++;
                
            }
            count+=j;
        }
        
        return count;
    }
};