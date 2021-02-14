/* Write a function that takes a string as input and reverse only the vowels of a string. */

class Solution {
    boolean isVowel(char ch) {
        
        return ch == 'a' || ch == 'e'
            || ch == 'i' || ch == 'o'
            || ch == 'u' || ch == 'A' 
            || ch == 'E' || ch == 'I' 
            || ch == 'O' || ch == 'U';
    }
    public String reverseVowels(String s) {
    
        int start = 0;
        int end = s.length()-1;
        StringBuilder res = new StringBuilder(s);
        while(start<end) {
            
            if(isVowel(res.charAt(start)) && isVowel(res.charAt(end))) {
                char temp = res.charAt(start);
                res.setCharAt(start,res.charAt(end));
                res.setCharAt(end,temp);
                start++;
                end--;
                continue;
            }
            if(!isVowel(res.charAt(start))) {
                start++;
            }
            if(!isVowel(res.charAt(end))) {
                end--;
            }
            
        }
        
        return res.toString();
    }
}