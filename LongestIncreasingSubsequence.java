/* Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. */

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxm = 1;
        for(int i=1;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxm = Math.max(maxm,dp[i]);
        }
        return maxm;
    }
}