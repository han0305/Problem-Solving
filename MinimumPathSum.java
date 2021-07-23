/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time. */

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i=1;i<n;i++) {
            dp[i] = dp[i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                }
                else {
                    dp[j] = grid[i][j] + Math.min(dp[j-1],dp[j]);
                }
            }
        }
        
        return dp[n-1];
    }
}