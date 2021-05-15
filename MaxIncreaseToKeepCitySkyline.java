/* In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased? */

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                rowMax[i] = Math.max(rowMax[i],grid[i][j]);
                colMax[j] = Math.max(colMax[j],grid[i][j]);
            }
        }
        
        int sum = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                    sum+=Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return sum;
    }
}