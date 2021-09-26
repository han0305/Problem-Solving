/* You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot. */

class Solution {
    public long gridGame(int[][] grid) {
        int m = 2;
        int n = grid[0].length;
        long[][] prefixSum = new long[m][n];
        prefixSum[0][0] = grid[0][0];
        prefixSum[1][0] = grid[1][0];
        for(int i=0;i<m;i++) {
            for(int j=1;j<n;j++) {
                prefixSum[i][j] = prefixSum[i][j-1]+grid[i][j];
            }
        }
        long minm = prefixSum[0][n-1]-prefixSum[0][0];
        for(int i=1;i<n;i++) {
            long currMax = Math.max(prefixSum[0][n-1]-prefixSum[0][i],prefixSum[1][i-1]);
            minm = Math.min(minm,currMax);
        }
        
        return minm;
    }
}