/* You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands. */

class Solution {
    private int[] xMoves = {1,-1,0,0};
    private int[] yMoves = {0,0,1,-1};
    
    boolean dfs(int row, int col, int[][] grid1, int[][] grid2, int[][] visited) {
        
        visited[row][col] = 1;
        boolean res = grid1[row][col] == 1 ? true : false;
        for(int i=0;i<xMoves.length;i++) {
            int nextRow = row+xMoves[i];
            int nextCol = col+yMoves[i];
            if(nextRow>=0 && nextRow<grid2.length && nextCol>=0 && nextCol<grid2[row].length && grid2[nextRow][nextCol]==1 && visited[nextRow][nextCol] == 0) {
                res = dfs(nextRow,nextCol,grid1,grid2,visited) && res;
            }
        }
        
        return res;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
     
        int[][] visited = new int[grid2.length][grid2[0].length];
        
        int count = 0;
        for(int i=0;i<grid2.length;i++) {
            for(int j=0;j<grid2[i].length;j++) {
                if(grid2[i][j] == 1 && visited[i][j] == 0) {
                    if(dfs(i,j,grid1,grid2,visited)) {
                        
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}