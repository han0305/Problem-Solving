/* Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix. */

class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> cumSum(m,vector<int>(n));
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                cumSum[i][j]+=mat[i][j] + (j>0?cumSum[i][j-1]:0);
            }
        }
        vector<vector<int>> res(m,vector<int>(n));
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                
                int left = j-k-1>=0?j-k-1:-1;
                int right = j+k<n?j+k:n-1;
                for(int l = 0;l<=k;l++) {
                    if(left==-1) {
                        if(i-l>=0)
                        res[i][j]+=cumSum[i-l][right];
                        if(l!=0 && i+l<m)
                        res[i][j]+=cumSum[i+l][right];
                    }
                    else {
                        if(i-l>=0)
                        res[i][j]+=(cumSum[i-l][right]-cumSum[i-l][left]);
                        if(l!=0 && i+l<m)
                        res[i][j]+=(cumSum[i+l][right]-cumSum[i+l][left]);
                    }
                }
                
            }
        }
        
        return res;
    }
};