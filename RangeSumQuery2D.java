/* Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2). */

class NumMatrix {

    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++) {
            for(int j=1;j<=matrix[0].length;j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] + matrix[i-1][j-1] - prefixSum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2+1][col2+1] - prefixSum[row2+1][col1] - prefixSum[row1][col2+1] + prefixSum[row1][col1];
    }
}