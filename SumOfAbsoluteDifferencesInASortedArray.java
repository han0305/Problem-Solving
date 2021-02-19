/* You are given an integer array nums sorted in non-decreasing order.

Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.

In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed). */

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=1;i<nums.length;i++) {
            res[0]+=(nums[i]-nums[0]);
        }
        
        for(int i=1;i<nums.length;i++) {
            int left = i-1;
            int right = (nums.length-i)-1;
            int diff = nums[i]-nums[i-1];
            res[i] = res[i-1]+left*diff-right*diff;
        }
        return res;
    }
}