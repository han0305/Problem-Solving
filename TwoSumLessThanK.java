/* Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1. */

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int maxm = -1;
        while(i<j) {
            int sum = nums[i]+nums[j];
            if(sum>=k) {
                j--;
            }
            else {
                maxm = Math.max(maxm,sum);
                i++;
            }
        }
        return maxm;
    }
}