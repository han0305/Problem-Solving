/* In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead. */

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m  = grid.size();
        int n = grid[0].size();
        queue<pair<int,int>> q;
        vector<vector<int>> time(m,vector<int>(n,-1));
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    q.push({i,j});
                    time[i][j] = 0;
                }
            }
        }
        q.push({-1,-1});
        int t =1;
        while(!q.empty()) {
            int i = q.front().first;
            int j = q.front().second;
            q.pop();
            if(i == -1 && j == -1) {
               
                if(!q.empty()) {
                    q.push({-1,-1});
                    t++;
                }
                continue;
            }
           
            if(i+1<m && grid[i+1][j] == 1 && time[i+1][j] == -1){
                time[i+1][j] = t;
                q.push({i+1,j});
                 //cout<<i+1<<" "<<j<<" "<<t<<endl;
            }
            if(i-1>=0 && grid[i-1][j] == 1 && time[i-1][j] == -1){
                time[i-1][j] = t;
                q.push({i-1,j});
                 //cout<<i-1<<" "<<j<<" "<<t<<endl;
            }
            if(j+1<n && grid[i][j+1] == 1 && time[i][j+1] == -1){
                
                time[i][j+1] = t;
                q.push({i,j+1});
                // cout<<i<<" "<<j+1<<" "<<t<<endl;
            }
            if(j-1>=0 && grid[i][j-1] == 1 && time[i][j-1] == -1){
                time[i][j-1] = t;
                q.push({i,j-1});
                // cout<<i<<" "<<j-1<<" "<<t<<endl;
            }
            
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(time[i][j] == -1 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return t-1;
    }
};