/* Given a string s and an integer k. You should construct k non-empty palindrome strings using all the characters in s.

Return True if you can use all the characters in s to construct k palindrome strings or False otherwise. */

class Solution {
    public boolean canConstruct(String s, int k) {
        
        if(s.length()<k)
            return false;
        if(s.length() == k)
            return true;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) 
            freq[s.charAt(i)-'a']++;
        int oddCount = 0;
        for(int i=0;i<freq.length;i++) {
            if(freq[i]%2!=0)
                oddCount++;
        }
        
        return oddCount<=k?true:false;
    }
}