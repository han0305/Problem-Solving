/* Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            int start = 0;
            int end = res; 
            while(start<end) {
                int mid = (start+end)/2;
                if(lis[mid]<nums[i]) {
                    start = mid+1;
                }
                else {
                    end = mid;
                }
            }
            lis[start] = nums[i];
            if(start == res) {
                res++;
            }
        }
        return res;
    }
}