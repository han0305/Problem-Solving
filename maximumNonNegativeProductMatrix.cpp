/* You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.

Notice that the modulo is performed after getting the maximum product. */

class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        int m = grid.size();
        int mod = 1e9+7;
        if(m==0) return 0;
        
        int n = grid[0].size();
        
        long long int maxm[m][n],minm[m][n];
        
        maxm[0][0] = minm[0][0] = grid[0][0];
        for(int i=1;i<n;i++) {
            maxm[0][i] = minm[0][i] = grid[0][i] * maxm[0][i-1];
        }
        
        for(int i=1;i<m;i++) {
            maxm[i][0] = minm[i][0] = grid[i][0] * maxm[i-1][0];
        }
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                
                if(grid[i][j]<0) {
                    minm[i][j] = max(maxm[i-1][j],maxm[i][j-1]) * grid[i][j];
                    maxm[i][j] = min(minm[i-1][j],minm[i][j-1]) * grid[i][j];
                }
                else {
                    minm[i][j] = min(minm[i-1][j],minm[i][j-1]) * grid[i][j];
                    maxm[i][j] = max(maxm[i-1][j],maxm[i][j-1]) * grid[i][j];
                }
                
            }
        }
        int res = maxm[m-1][n-1]%mod;
        return res<0?-1:res;
    }
};