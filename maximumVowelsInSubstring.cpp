/*  Given a string s and an integer k.

Return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are (a, e, i, o, u).  */

class Solution {
public:
    bool isVowel(char ch) {
        
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch=='o' || ch == 'u') 
            return true;
        return false;
    }
    int maxVowels(string s, int k) {
        
        int l = s.length();
        int count = 0;
        int maxm = INT_MIN;
        int j = 0;
        
        for(int i=0;i<l;i++) {
            
            if(isVowel(s[i])) 
                count++;
            if(i-j+1 == k) {
                maxm = max(maxm,count);
                if(isVowel(s[j]))
                    count--;
                j++;
                
            }
            
        }
       return maxm; 
    }
};