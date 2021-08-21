/* You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above. */

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int min = Integer.MAX_VALUE;
        long res = 0;
        int n = matrix.length;
        int negCount = 0;
        int zeroCount = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                res+=Math.abs(matrix[i][j]);
                min = Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j]<0) {
                    negCount++;
                }
                else if(matrix[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        if(negCount%2==0 || zeroCount>0) {
            return res;
        }
        return res-(min+Math.abs(min));
    }
}