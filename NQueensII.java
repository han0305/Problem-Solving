/* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle. */

class Solution {
    private boolean isValid(int row, int col, int[][] board) {
        
        for(int i=0;i<row;i++) {
            if(board[i][col]==1)
                return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
            if(board[i][j]==1)
                return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++) {
            if(board[i][j]==1)
                return false;
        }
        return true;
    }
    private int getDistinctSolutions(int row, int[][] board) {
        if(row==board.length) {
            return 1;
        }
        int count = 0;
        for(int i=0;i<board.length;i++) {
            if(isValid(row,i,board)) {
                board[row][i] = 1;
                count+=getDistinctSolutions(row+1,board);
                board[row][i] = 0;
            }
        }
        return count;
        
    }
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return getDistinctSolutions(0, board);
    }
}