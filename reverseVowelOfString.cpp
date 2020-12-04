/* Write a function that takes a string as input and reverse only the vowels of a string. */

class Solution {
public:
    bool isVowel(char a) {
        return a == 'a' || a=='e' || a=='i' || a=='o' || a=='u' ||
             a == 'A' || a=='E' || a=='I' || a=='O' || a=='U';
    }
    string reverseVowels(string s) {
        int i = 0;
        int j = s.length()-1;
        int left = -1;
        int right = -1;
        while(i<j) {
           if(isVowel(s[i]) && isVowel(s[j])) {
               char temp = s[i];
               s[i] = s[j];
               s[j] = temp;
               i++;
               j--;
           }
            else if(isVowel(s[i]))
                j--;
            else 
                i++;
        }
        return s;
    }
};