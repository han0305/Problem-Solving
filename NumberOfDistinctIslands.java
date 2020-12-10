/* Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other. */ 


class Solution {
    
    public void dfs(int row,int col,int m,int n,int[][] grid,int[][] visited,ArrayList<Integer> pathSig,int sig) {
        
        pathSig.add(sig);
        visited[row][col] = 1;
        int count = 1;
        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};
        for(int i=0;i<4;i++) {
            int newRow = row+x[i];
            int newCol = col+y[i];
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n &&  grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                dfs(newRow,newCol,m,n,grid,visited,pathSig,count);
            }
            else {
                pathSig.add(-1);
            }
            count++;
            
        }
    }
    
    public int numDistinctIslands(int[][] grid) {
        if(grid.length==0)
            return 0;
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        int visited[][] = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    ArrayList<Integer> pathSig = new ArrayList<Integer>();
                    dfs(i,j,grid.length,grid[i].length,grid,visited,pathSig,0);
                    hs.add(pathSig);
                }
                
            }
        }
        
        return hs.size();
    }
}