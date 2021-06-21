/* Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements. */

class Solution {
    private int longestPalindromeSubseqUtil(String s, int left, int right, int[][] mem) {
        if(left>right) {
            return 0;
        }
        if(left == right) {
            return 1;
        }
        if(mem[left][right]!=-1) {
            return mem[left][right];
        }
        if(s.charAt(left) == s.charAt(right)) {
            mem[left][right] = 2+longestPalindromeSubseqUtil(s,left+1,right-1,mem);
            return mem[left][right];
        }
        mem[left][right] = Math.max(longestPalindromeSubseqUtil(s,left+1,right,mem),longestPalindromeSubseqUtil(s,left,right-1,mem));
         return mem[left][right];      
    }
    public int longestPalindromeSubseq(String s) {
        int[][] mem = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<s.length();j++) {
                mem[i][j] = -1;
            }
        }
        return longestPalindromeSubseqUtil(s,0,s.length()-1,mem);
    }
}