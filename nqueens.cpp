/* Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively. */

class Solution {
public:
    bool isValid(vector<string> res,int row,int col,int n){
        
        for(int i=0;i<row;i++) {
            if(res[i][col] == 'Q')
                return false;
        }
        int i = row-1;
        int j = col-1;
        while(i>=0 && j>=0) {
            if(res[i--][j--] == 'Q')
                return false;
        }
        
        i = row-1;
        j = col+1;
        while(i>=0 && j<n) {
            if(res[i--][j++] == 'Q')
                return false;
        }
        return true;
    }
    
    void placeQueens(vector<vector<string>>& res,int row,int n,vector<string>& temp) {
        if(row == n) {
            res.push_back(temp);
            return ;
        }
        for(int i=0;i<n;i++) {
            temp[row][i] = 'Q';
            if(isValid(temp,row,i,n)){
                placeQueens(res,row+1,n,temp);
            }
            temp[row][i] = '.';
            
        }   
    }
    
    vector<vector<string>> solveNQueens(int n) {
        
        vector<vector<string>> res;
        vector<string> temp(n,string(n,'.'));
        placeQueens(res,0,n,temp);
        return res;
    }
};