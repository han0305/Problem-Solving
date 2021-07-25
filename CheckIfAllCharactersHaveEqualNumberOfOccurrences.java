/* Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency). */

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        int f = 0;
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
            if(i == s.length()-1) {
                f =  freq[s.charAt(i)-'a'];
            }
        }
        for(int i=0;i<26;i++) {
            if(freq[i]==0) {
                continue;
            }
            if(freq[i]!=f) {
                return false;
            }
        }
        return true;
    }
}