/* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules. */

class Solution {
    
    public int getBoxNumber(int row,int col) {
        
        if(row<=2) {
            if(col<=2) {
                return 0;
            }
            else if(col<=5) {
                 return 1;
            }
            else {
                 return 2;
            }
            
        }
        else if(row<=5) {
            if(col<=2) {
                 return 3;
            }
            else if(col<=5) {
                 return 4;
            }
            else {
                 return 5;
            }
            
        }
        else  {
            
            if(col<=2) {
                 return 6;
            }
            else if(col<=5) {
                 return 7;
            }
            else {
                 return 8;
            }
            
            
        }
        
    }
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer> boxMap[] = new HashMap[9];
        HashMap<Character,Integer> rowMap[] = new HashMap[9];
        HashMap<Character,Integer> colMap[] = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rowMap[i] = new HashMap<Character,Integer>();
            colMap[i] = new HashMap<Character,Integer>();
            boxMap[i] = new HashMap<Character,Integer>();
        }
        for(int i=0;i<9;i++) {
            
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.'){
                    int boxNo = getBoxNumber(i,j);
                    if(boxMap[boxNo].containsKey(board[i][j])) {
                       return false;
                    }
                    if(rowMap[i].containsKey(board[i][j])) {
                        return false;
                    }
                    if(colMap[j].containsKey(board[i][j])) {
                        return false;
                    }
                    rowMap[i].put(board[i][j],1);
                    colMap[j].put(board[i][j],1);
                    boxMap[boxNo].put(board[i][j],1);
               }
               
               
                
            }
        }
        
        return true;
        
    }
}