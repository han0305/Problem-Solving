/* An array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].

For example, consider 0-indexing:

[1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
[1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
A subarray is a contiguous subsequence of the array.

Given an integer array nums of distinct integers, return the largest subarray of nums of length k. */

class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        int maxIdx = 0;
        for(int i = 1;i<=n-k;i++) {
            if(nums[i]>nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int[] res = new int[k];
        int j = 0;
        while(k>0){
            res[j++] = nums[maxIdx++];
            k--;
        }
        return res;
    }
}