/* Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1]. */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
     
        int n = nums.length;
        int maxm = 1;
        int currMax = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]>nums[i-1]) {
                currMax++;
            } else {
                currMax = 1;
            }
            maxm = Math.max(maxm,currMax);
        }
        
        return maxm;
    }
}