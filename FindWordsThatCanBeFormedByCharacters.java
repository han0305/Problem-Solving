/* You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words. */

class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charFreq = new int[26];
        
        for(int i=0;i<chars.length();i++) {
            
            charFreq[chars.charAt(i)-'a']++;
        }
        
        int sum = 0;
        
        for(int i=0;i<words.length;i++) {
            
            int[] wordFreq = new int[26];
            
            for(int j=0;j<words[i].length();j++) {
                
                wordFreq[words[i].charAt(j)-'a']++;
             
            }
            
            boolean isGood = true;
            for(int j=0;j<26;j++) {
                
                if(wordFreq[j]>charFreq[j]) {
                    isGood = false;
                    break;
                }
            }
            
            if(isGood) {
                
                sum=sum+words[i].length();
            }
        }
        
        return sum;
    }
}