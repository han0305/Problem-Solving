/* Given a rows x cols matrix grid representing a field of cherries. Each cell in grid represents the number of cherries that you can collect.

You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0) , and Robot #2 is located at the top-right corner (0, cols-1) of the grid.

Return the maximum number of cherries collection using both robots  by following the rules below:

From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
When both robots stay on the same cell, only one of them takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in the grid. */

class Solution {
    private int[] moves = {-1,0,1};
    private int getMaxCherries(int[][] grid, int row, int col1, int col2,int[][][] mem) {
        
        if(row == grid.length) {
            return 0;
        }
        if(mem[row][col1][col2]!=-1) {
            return mem[row][col1][col2];
        }
        int c1 = 0, c2 = 0;
        if(col1 == col2) {
            c1 = grid[row][col1];
        } else {
            c1 = grid[row][col1];
            c2 = grid[row][col2];
        }
        int currMax = Integer.MIN_VALUE;
        for(int i=0;i<moves.length;i++) {
            int newCol1 = col1+moves[i];
            if(newCol1<0 || newCol1>=grid[row].length) {
                continue;
            }
            for(int j=0;j<moves.length;j++) {
                int newCol2 = col2+moves[j];
                if(newCol2<0 || newCol2>=grid[row].length) {
                    continue;
                }
                currMax = Math.max(currMax, c1+c2+getMaxCherries(grid,row+1,newCol1,newCol2,mem));
            }
        }
        return mem[row][col1][col2] = currMax;
    }
    public int cherryPickup(int[][] grid) {
        int[][][] mem = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                for(int k=0;k<grid[0].length;k++) {
                    mem[i][j][k] = -1;
                }
            }
        }
        return getMaxCherries(grid,0,0,grid[0].length-1,mem);
    }
}