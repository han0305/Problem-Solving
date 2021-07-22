/* You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.

Notice that the modulo is performed after getting the maximum product. */

class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for(int i=1;i<n;i++) {
            dp[0][i][0] = dp[0][i][1] = dp[0][i-1][0]*grid[0][i]; 
        }
        for(int i=1;i<m;i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i-1][0][0] * grid[i][0];
        }
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                
                dp[i][j][0] = Math.max(Math.max(grid[i][j]*dp[i-1][j][0],grid[i][j]*dp[i-1][j][1]), Math.max(grid[i][j]*dp[i][j-1][0],grid[i][j]*dp[i][j-1][1]));
                dp[i][j][1] = Math.min(Math.min(grid[i][j]*dp[i-1][j][0],grid[i][j]*dp[i-1][j][1]), Math.min(grid[i][j]*dp[i][j-1][0],grid[i][j]*dp[i][j-1][1]));
            }
        }
        
        return dp[m-1][n-1][0]<0?-1:(int)(dp[m-1][n-1][0]%mod);
    }
}