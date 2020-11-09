/* Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1). 

Constraints:

2 <= A.length <= 1000
0 <= A[i] <= 500

*/

class Solution {
public:
    int longestArithSeqLength(vector<int>& A) {
        int n = A.size();
        vector<vector<int>> dp(n,vector<int>(1001,0));
        int maxm = INT_MIN;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                int diff = A[i]-A[j]+500;
                int len = 2;
                dp[i][diff] = max(len,1+dp[j][diff]);
                maxm = max(maxm,dp[i][diff]);
                
            }
            
        }
        return maxm;
    }
};