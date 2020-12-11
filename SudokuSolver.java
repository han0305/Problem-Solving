/* Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells. */ 

class Solution {
    private HashSet<Character>[] rowSet,colSet,boxSet;
    private int getBoxNumber(int row,int col) {
        
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
    private boolean backtrack(int curr, ArrayList<ArrayList<Integer>> fill, char[][] board) {
        
        if(curr >= fill.size()) 
            return true;
        int row = fill.get(curr).get(0);
        int col = fill.get(curr).get(1);
        int boxNo = getBoxNumber(row,col);
        for(int i=1;i<=9;i++) {
            char no = (char)(i+'0');
            if(!rowSet[row].contains(no) && !colSet[col].contains(no) && !boxSet[boxNo].contains(no)) {
                board[row][col] = no;
                rowSet[row].add(no);
                colSet[col].add(no);
                boxSet[boxNo].add(no);
                if(backtrack(curr+1,fill,board))
                    return true;
                rowSet[row].remove(no);
                colSet[col].remove(no);
                boxSet[boxNo].remove(no);
                
            }
      }
        
      return false;  
        
        
    }
    public void solveSudoku(char[][] board) {
        
        rowSet = new HashSet[9];
        colSet = new HashSet[9];
        boxSet = new HashSet[9];
        for(int i=0;i<9;i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            boxSet[i] = new HashSet<Character>();
        }
        ArrayList<ArrayList<Integer>> fill = new ArrayList();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    int boxNo = getBoxNumber(i,j);
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    boxSet[boxNo].add(board[i][j]);
                }
                else {
                    fill.add(new ArrayList<Integer>());
                    fill.get(fill.size()-1).add(i);
                    fill.get(fill.size()-1).add(j);
                    
                }
            }
        }
        if(fill.size()>0) {
            int curr = 0;
            backtrack(curr,fill,board);
        }
        
    }
}