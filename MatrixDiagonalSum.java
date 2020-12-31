/* Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal. */

class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int pr,pc;
        pr = pc = 0;
        int sr = 0;
        int sc = n-1;
        int sum = 0;
        while(pr<m && pc<n) {
            if(pr == sr && pc == sc) {
                sum += mat[pr][pc];
            }
            else {
                sum += mat[pr][pc]+mat[sr][sc];
            }
            pr++;
            pc++;
            sr++;
            sc--;
        } 
        return sum;
    }
}