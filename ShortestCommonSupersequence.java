/* Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.) */

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        
        for(int i=1;i<=str1.length();i++) {
            for(int j=1;j<=str2.length();j++) {
                dp[i][j] = str1.charAt(i-1)==str2.charAt(j-1)?1+dp[i-1][j-1]:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        StringBuilder res = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        
        while(i>0 && j>0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                res.append(str1.charAt(i-1));
                i=i-1;
                j=j-1;
            }
            else {
                if(dp[i-1][j]>dp[i][j-1]) {
                    res.append(str1.charAt(i-1));
                    i=i-1;
                }
                else {
                    res.append(str2.charAt(j-1));
                    j=j-1;
                }
            }
        }
        while(i>0) {
            res.append(str1.charAt(i-1));
            i=i-1;
        }
        while(j>0) {
            res.append(str2.charAt(j-1));
            j=j-1;
        }
        return res.reverse().toString();
    }
}