/* Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid. */

class Solution {
    public int countNegatives(int[][] grid) {
        
        int i = 0;
        int j = grid[0].length-1;
        int count = 0;
        while(i<grid.length && j>=0) {
            
            if(grid[i][j] < 0) {
                j--;
            }
            else {
                count+=(grid[i].length-(j+1));
                i++;
            }
            
        }
        if(j+1 == 0 && i == grid.length-1 && grid[i][j+1]<0) {
            count+=(grid[i].length-(j+1));
        }
        else if(j+1 == 0 && i<grid.length) {
            int remRows = grid.length-i;
            int currCount = (grid[i].length-(j+1));
            count+=remRows*currCount;
        }
        return count;
    }
}