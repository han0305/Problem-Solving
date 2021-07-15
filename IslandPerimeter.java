/* You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island. */

class Solution {
    private int[] xDir = {1,-1,0,0};
    private int[] yDir = {0,0,1,-1};
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                for(int k=0;k<xDir.length;k++) {
                    int x = i+xDir[k];
                    int y = j+yDir[k];
                    if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == 0) {
                        res++;
                    }
                }
            } 
        }
        return res;
    }
}