/* On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once. */

class Solution {

    private int[] rowMoves = {1,-1,0,0};
    private int[] colMoves = {0,0,1,-1};
    
    private int getUniquePaths(int currRow,int currCol,int currCount, int zeroCount,int[][] grid, int[][] visited) {
        if(grid[currRow][currCol] == 2) {
            if(currCount == zeroCount) {
                return 1;
            }
            else
                return 0;
        }
        visited[currRow][currCol] = 1;
        int total = 0;
        for(int i=0;i<rowMoves.length;i++) {
            int newRow = currRow+rowMoves[i];
            int newCol = currCol+colMoves[i];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[currRow].length && grid[newRow][newCol]!=-1 && visited[newRow][newCol]==0) {
                currCount = grid[newRow][newCol]==0?currCount+1:currCount;
                total+=getUniquePaths(newRow,newCol,currCount,zeroCount,grid,visited);
                currCount = grid[newRow][newCol]==0?currCount-1:currCount;
            }
        }
        visited[currRow][currCol] = 0;
        return total;
    } 
    
    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int startRow = -1;
        int startCol = -1;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]==0) {
                    zeroCount++;
                }
                else if(grid[i][j]==1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        int[][] visited = new int[grid.length][grid[0].length];
        int uniquePaths = getUniquePaths(startRow,startCol,0,zeroCount,grid,visited);
        return uniquePaths;
        
    }
}