/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid. */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++) {
            dp[i] = obstacleGrid[0][i] == 0?dp[i-1] : 0;
        }
        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(j==0) {
                    dp[j] = obstacleGrid[i][j] == 1?0:dp[j];
                    continue;
                }
                dp[j] = obstacleGrid[i][j] == 1?0 : dp[j]+dp[j-1];
            }
        }
        
        return dp[n-1];
    }
}