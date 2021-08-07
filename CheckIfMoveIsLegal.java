/* You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the cell (r, c) on a game board. On the board, free cells are represented by '.', white cells are represented by 'W', and black cells are represented by 'B'.

Each move in this game consists of choosing a free cell and changing it to the color you are playing as (either white or black). However, a move is only legal if, after changing it, the cell becomes the endpoint of a good line (horizontal, vertical, or diagonal).

A good line is a line of three or more cells (including the endpoints) where the endpoints of the line are one color, and the remaining cells in the middle are the opposite color (no cells in the line are free). */

class Solution {
    void getCount(char[][] board, int row, int col, int color, int[] counts, int idx) {
        
        if(board[row][col] == color && counts[idx] >=2) {
            counts[idx] = 0;
        }
        else if(board[row][col] == color || board[row][col] == '.') {
            counts[idx] = -1;
        }
        else {
            counts[idx]++;
        }
        
    }
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[] counts = {1,1,1,1,1,1,1,1};
        int upMove = rMove-1;
        int downMove = rMove+1;
        int leftMove = cMove-1;
        int rightMove = cMove+1;
        
        while(upMove>=0 || downMove<8 || leftMove>=0 || rightMove<8) {
            if(counts[0] != -1 && upMove>=0) {
                getCount(board,upMove,cMove,color,counts,0);
                if(counts[0] == 0) {
                    return true;
                } 
            }
            if(counts[1] !=-1 && upMove>=0 && rightMove<8) {
                getCount(board,upMove,rightMove,color,counts,1);
                if(counts[1] == 0) {
                    return true;
                }
            }
            if(counts[2]!=-1 && rightMove<8) {
                getCount(board,rMove,rightMove,color,counts,2);
                if(counts[2] == 0) {
                    return true;
                }
            }
            if(counts[3]!=-1 && downMove<8 && rightMove<8) {
                getCount(board,downMove,rightMove,color,counts,3);
                if(counts[3] == 0) {
                    return true;
                }
            }
            
            if(counts[4]!=-1 && downMove<8) {
                getCount(board,downMove,cMove,color,counts,4);
                if(counts[4] == 0) {
                    return true;
                }
            }
            if(counts[5]!=-1 && downMove<8 && leftMove>=0) {
                getCount(board,downMove,leftMove,color,counts,5);
                if(counts[5] == 0) {
                    return true;
                }
            }
            if(counts[6]!=-1 && leftMove>=0) {
                getCount(board,rMove,leftMove,color,counts,6);
                if(counts[6] == 0) {
                    return true;
                }
            }
            if(counts[7]!=-1 && upMove>=0 && leftMove>=0) {
                getCount(board,upMove,leftMove,color,counts,7);
                if(counts[7] == 0) {
                    return true;
                }
            }
            upMove--;
            leftMove--;
            rightMove++;
            downMove++;
        }
        return false;
    }
}