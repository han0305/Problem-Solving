/*  Given a string S, return the number of substrings of length K with no repeated characters. */

class Solution {
public:
    bool isAllUnique(int freq[]) {
        
        for(int i=0;i<26;i++) {
            
            if(freq[i]>1)
                return false;
        }
        return true;
    }
    int numKLenSubstrNoRepeats(string S, int K) {
        
        int l = S.length();
        int freq[26] = {0};
        int count=0;
        int j = 0;
        
        for(int i=0;i<l;i++) {
            freq[S[i]-'a']++;
            if(i-j+1 == K) {
                if(isAllUnique(freq))
                    count++;
                freq[S[j++]-'a']--;
                
            }
            
        }
        
        return count;
        
    }
};