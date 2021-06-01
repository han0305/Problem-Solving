/* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings. */


class Solution {
    
    private int getLongestCommonSubsequence(String text1, String text2, int idx1, int idx2, int[][] mem) {
        if(idx1<0 || idx2<0) {
            return 0;
        }
        if(mem[idx1][idx2]!=-1) {
            return mem[idx1][idx2];
        }
        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            mem[idx1][idx2] = 1+getLongestCommonSubsequence(text1,text2,idx1-1,idx2-1,mem);
            return mem[idx1][idx2];
        }
        mem[idx1][idx2] = Math.max(getLongestCommonSubsequence(text1,text2,idx1,idx2-1,mem),getLongestCommonSubsequence(text1,text2,idx1-1,idx2,mem));
        return mem[idx1][idx2];
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] mem = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++) {
            for(int j=0;j<text2.length();j++) {
                mem[i][j]=-1;
            }
        }
        return getLongestCommonSubsequence(text1,text2,text1.length()-1,text2.length()-1,mem);
    }
}
// class Solution {
    
//     private int getLongestCommonSubsequence(String text1, String text2, int idx1, int idx2, int count) {
        
//         if(idx1<0 || idx2<0) {
//             return count;
//         }
//         if(text1.charAt(idx1) == text2.charAt(idx2)) {
//             return getLongestCommonSubsequence(text1,text2,idx1-1,idx2-1,count+1);
//         }
//         return Math.max(getLongestCommonSubsequence(text1,text2,idx1,idx2-1,count),getLongestCommonSubsequence(text1,text2,idx1-1,idx2,count));
        
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
        
//         return getLongestCommonSubsequence(text1,text2,text1.length()-1,text2.length()-1,0);
//     }
// }