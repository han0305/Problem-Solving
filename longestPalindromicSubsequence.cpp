/* Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000. */

class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int l = s.length();
        vector<vector<int>> dp(l,vector<int>(l,0));
        for(int i=0;i<l;i++)
            dp[i][i] = 1;
        int col=1;
        for(int i=0;i<l;i++) {
            int row = 0;
            for(int j = col;j<l;j++) {
                
                if(s[row] == s[j]) {
                    dp[row][j] = 2 + dp[row+1][j-1];
                }
                else {
                    dp[row][j] = max(dp[row][j-1],dp[row+1][j]);
                }
                row++;
            }
            col++;
        }
        
        return dp[0][l-1];
    }
};