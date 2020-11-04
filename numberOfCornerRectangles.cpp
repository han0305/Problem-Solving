/* Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct. */

class Solution {
public:
    int countCornerRectangles(vector<vector<int>>& grid) {
        
        unordered_map<string,int> umap;
        int m = grid.size();
        if(m == 0) {
            return 0;
        }
        int n = grid[0].size();
        int sum = 0;
        for(int i=0;i<m;i++) {
            
            for(int j=1;j<n;j++) {
                
                if(grid[i][j] ==  1)
                for(int k = 0;k<j;k++) {
                    if(grid[i][k] == 1) {
                        
                        string key = to_string(j) + "_" + to_string(k);
                        sum+=umap[key];
                        umap[key]++;
                        
                    }
                    
                }
            }
            
            
        }
        
       return sum; 
    }
};