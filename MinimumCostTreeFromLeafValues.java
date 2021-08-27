/* Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children. */

class Solution {
    
    private int getLowestSum(int[] arr, int left, int right, int[][] mem) {
        
        if(left>=right) {
            return 0;
        }
        if(mem[left][right]!=0) {
            return mem[left][right];
        }
        int minm = Integer.MAX_VALUE;
        for(int i=left;i<right;i++) {
            int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
            for(int j = left;j<=i;j++) {
                lMax = Math.max(lMax,arr[j]);
            }
            for(int j = i+1;j<=right;j++) {
                rMax = Math.max(rMax,arr[j]);
            }
            minm = Math.min(minm, lMax*rMax+getLowestSum(arr,left,i,mem)+getLowestSum(arr,i+1,right,mem));
            
        }
        
        return mem[left][right] = minm;
        
    }
    public int mctFromLeafValues(int[] arr) {
        int[][] mem = new int[arr.length][arr.length];
        return getLowestSum(arr,0,arr.length-1,mem);
    }
}