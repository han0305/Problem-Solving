/* Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. */

class Solution {
public:
    bool isAlive(vector<vector<int>>& board,int m,int n,int r,int c) {
        
        vector<int> rMoves = {-1,-1,-1,0,1,1,1,0};
        vector<int> cMoves = {-1,0,1,1,1,0,-1,-1};
        int liveCount = 0;
        for(int i=0;i<8;i++) {
            int newRow = rMoves[i] + r;
            int newCol = cMoves[i] + c;
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n) {
                if(board[newRow][newCol] == 1)
                    liveCount++;
            }
        }
        if(board[r][c] == 1) {
            if(liveCount>=2 && liveCount<=3)
                return true;
            else
                return false;
        }
        else {
            if(liveCount == 3)
                return true;
            else return false;
        }
        
    }
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();
        
        vector<vector<int>> update(m,vector<int>(n));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isAlive(board,m,n,i,j))
                    update[i][j] = 1;
                else update[i][j] = 0;
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)
                board[i][j] = update[i][j];
        }
    }
};