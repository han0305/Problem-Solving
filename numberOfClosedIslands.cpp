/* Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands. */

class Solution {
public:
    bool dfs(int row,int col,int m,int n,vector<vector<int>>& grid,vector<vector<int>>& visited) {
        
        if(grid[row][col] == 1) {
            return true;
        }
        visited[row][col] = 1;
        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};
        bool isValid = true;
        for(int i=0;i<4;i++) {
            int newRow = row+x[i];
            int newCol = col+y[i];
            if(newRow>=m || newRow<0 || newCol>=n || newCol<0) {
                isValid =  false;
            }
            else if(visited[newRow][newCol]!=1) {
                isValid = isValid & dfs(newRow,newCol,m,n,grid,visited);
            }
        }
        return isValid;
    }
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        if(m==0) 
            return 0;
        int n = grid[0].size();
        int count = 0;
        vector<vector<int>> visited(m,vector<int>(n,0));
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=1 && visited[i][j]!=1 && dfs(i,j,m,n,grid,visited)) {
                    count++;
                }
                
            }
        }
        
        return count;
    }
};