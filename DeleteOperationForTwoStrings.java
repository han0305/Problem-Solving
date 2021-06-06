/* Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string. */

class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();i++) {
            dp[i][0] = i; 
        }
        for(int j=1;j<=word2.length();j++) {
            dp[0][j] = j;
        }
        for(int i=1;i<=word1.length();i++) {
            for(int j=1;j<=word2.length();j++) {
                dp[i][j] = word1.charAt(i-1)==word2.charAt(j-1)?dp[i-1][j-1]:1+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}