/* Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one. */

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int m = A.size();
        vector<vector<int>> dp(m,(vector<int>(m,0)));
        
        for(int i=0;i<m;i++) {
            
            for(int j=0;j<m;j++) {
                
                if(i==0) {
                    dp[i][j] = A[i][j];
                }
                else {
                    int minm = dp[i-1][j]+A[i][j];
                    if(j-1 >=0) {
                        minm = min(dp[i-1][j-1]+A[i][j],minm);
                    }
                    
                    if(j+1 < m) {
                        minm = min(dp[i-1][j+1]+A[i][j],minm);
                    }
                    dp[i][j] = minm;
                }
            }
        }
        
        int res = INT_MAX;
        for(int i=0;i<m;i++) {
            res = min(res,dp[m-1][i]);
        }
        return res;
    }
};