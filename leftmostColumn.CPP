/*A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.*/

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *   public:
 *     int get(int row, int col);
 *     vector<int> dimensions();
 * };
 */

class Solution {
public:
    
    int getLeftMostCol(BinaryMatrix binaryMatrix,int row,int m,int n) {
        
        int start = 0;
        int end = n-1;
        int leftMost = INT_MAX;
        
        while(start<=end) {
            
            int mid = (start+end)/2;
            int no = binaryMatrix.get(row,mid);
            if(no == 1) {
              leftMost = mid;
              end = mid-1;
            }
            else if(no == 0) {
                start = mid+1;
            }
            
            
        }
        return leftMost;
        
    }
    
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        vector<int> dim = binaryMatrix.dimensions();
        int m = dim[0];
        int n = dim[1];
        int leftMost = INT_MAX;
        for(int i = 0;i<m;i++) {
            
            int currLeftMost = getLeftMostCol(binaryMatrix,i,m,n);
            leftMost = min(leftMost,currLeftMost);
            
        }
        
        return leftMost == INT_MAX?-1:leftMost;
    }
};