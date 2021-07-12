/* You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists. */

class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row,int col) {
            this.row = row;
            this.col = col;
        }
    }
    private int[] xMoves = {1,-1,0,0};
    private int[] yMoves = {0,0,1,-1};
    public int nearestExit(char[][] maze, int[] entrance) {
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        int count = 0;
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        q.offer(new Pair(entrance[0],entrance[1]));
        boolean isEntrance = true;
        int res = 0;
        int currLen = 1;
        visited[entrance[0]][entrance[1]] = 1;
        boolean found = false;
        while(!q.isEmpty()) {
            
            Pair curr = q.pop();
            for(int i=0;i<xMoves.length;i++) {
                int newRow = curr.row + xMoves[i];
                int newCol = curr.col + yMoves[i];
                if(newRow>=m || newRow<0 || newCol>=n || newCol<0) {
                    if(!isEntrance) {
                        found = true;
                        break;
                    }
                }
                else if(maze[newRow][newCol]!='+' && visited[newRow][newCol] == 0) {
                    q.offer(new Pair(newRow,newCol));
                    visited[newRow][newCol] = 1;
                }
            }
            
            if(found) {
                break;
            }
            if(isEntrance) {
                isEntrance = false;
            }
            currLen--;
            if(currLen == 0) {
                res++;
                currLen = q.size();
            }
            
        }
        return found?res:-1;
    }
}