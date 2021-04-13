/* You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false. */

class Solution {
    private boolean isVowel(char ch) {
        
        return ch == 'a' || ch == 'e' 
            || ch == 'i' || ch == 'o' 
            || ch == 'u' || ch == 'A'
            || ch == 'E' || ch == 'I'
            || ch == 'O' || ch == 'U';
        
    }
    public boolean halvesAreAlike(String s) {
        
        int firstHalfCount = 0;
        int secondHalfCount = 0;
        
        for(int i=0;i<s.length();i++) {
            
            if(isVowel(s.charAt(i))) {
                if(i<s.length()/2)
                    firstHalfCount++;
                else 
                    secondHalfCount++;
            }
        }
        
        return firstHalfCount == secondHalfCount;
    }
}