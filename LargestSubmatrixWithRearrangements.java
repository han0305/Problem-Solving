/* You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally. */

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        if(m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] cumSum = new int[m][n];
        
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<m;j++) {
                if(matrix[j][i] == 0) {
                    cumSum[j][i] = 0;
                    count = 0;
                }
                else {
                    count++;
                    cumSum[j][i] = count;
                }
                
            }
        }
        
        int maxm = 0;
        for(int i=0;i<m;i++) {
            Arrays.sort(cumSum[i]);
            for(int j=0;j<n;j++) {
                int currMax = (n-j)*cumSum[i][j];
                maxm = Math.max(currMax,maxm);
                
            }
        }
        return maxm;
    }
}