/* A string is considered beautiful if it satisfies the following conditions:

Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.

A substring is a contiguous sequence of characters in a string. */

class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    private boolean isSorted(char ch, int[] freq) {
        
        int curr = ch-'a';
        for(int i=0;i<26;i++) {
            if(isVowel((char)(i+'a'))) {
                
                if(i<curr && freq[i] == 0) {
                    return false;
                }
                if(i>curr && freq[i] == 1) {
                    return false;
                }
            }
        }
        return true;
        
    }
    private boolean allVowels(int[] freq) {
        int count = 0;
        for(int i=0;i<26;i++) {
             if(isVowel((char)(i+'a')) && freq[i]==1) {
                 count++;
             }
        }
        return count==5;
    }
    public int longestBeautifulSubstring(String word) {
        int[] freq = new int[26];
        int j = 0;
        int maxm = 0;
        for(int i=0;i<word.length();i++) {
            if(!isVowel(word.charAt(i))) {
                j=-1;
                freq = new int[26];
                continue;
            }
            if(!isSorted(word.charAt(i),freq)) {
                freq = new int[26];
                if(word.charAt(i) == 'a') {
                freq[0]=1;
                j=i;
                }
                else
                j=-1;
                continue;
            }
            if(j==-1) {
               j=i;
            }
            freq[word.charAt(i)-'a'] = 1;
            if(allVowels(freq)) {
                maxm = Math.max(maxm,i-j+1);
            }
        }
        
        return maxm;
    }
}