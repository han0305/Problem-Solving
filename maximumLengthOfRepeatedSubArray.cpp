/* Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays. */

class Solution {
public:
    int findLength(vector<int>& A, vector<int>& B) {
        
        int l1 = A.size();
        int l2 = B.size();
        vector<vector<int>> dp(l1+1,vector<int>(l2+1,0));
        int maxm = INT_MIN;
        for(int i=1;i<=l1;i++) {
            
            for(int j=1;j<=l2;j++) {
                if(A[i-1] == B[j-1]) {
                    if(i!=1 && j!=1) {
                        if(A[i-2] == B[j-2]) {
                            dp[i][j] = 1 + dp[i-1][j-1];
                        }
                        else 
                            dp[i][j] = 1;
                    }
                    else 
                        dp[i][j] = 1;
                    
                }
                maxm = max(maxm,dp[i][j]);
            }
        }
        
        return maxm;
    }
};