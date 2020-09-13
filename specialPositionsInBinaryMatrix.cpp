/*Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.

A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).*/


class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        unordered_map<int,int> row;
        unordered_map<int,int> col;
        int m = mat.size();
        int n = mat[0].size();
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                
                if(mat[i][j] == 1) {
                        if(row.find(i) == row.end()) {
                            row[i] = 1;
                        }
                       else {
                           row[i]++;
                       }
                     if(col.find(j) == col.end()) {
                            col[j] = 1;
                        }
                       else {
                           col[j]++;
                       }
                }
                
          }
        }
        
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    count++;
            }
        } 
        return count;
    }
};