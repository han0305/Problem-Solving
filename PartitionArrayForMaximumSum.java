/* Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer. */

class Solution {
    private int maxSumUtil(int[] arr, int k, int idx, int count, int sum, int currMax) {
        
        if(idx == arr.length) {
            return sum+currMax*count;
        }
        
        if(count == k) {
            sum+=currMax*count;
            return maxSumUtil(arr,k,idx+1,1,sum,arr[idx]);
        }
        
        return Math.max(maxSumUtil(arr,k,idx+1,count+1,sum,Math.max(currMax,arr[idx])), maxSumUtil(arr,k,idx+1,1,sum+currMax*count,arr[idx]));
        
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSumUtil(arr,k,0,0,0,Integer.MIN_VALUE);
    }
}