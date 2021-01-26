/* Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false. */

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return false;
        int minm = nums[0];
        for(int j=1;j<n-1;j++) {
            for(int k=j+1;k<n;k++) {
                if(nums[k]<nums[j] && nums[j]>minm && nums[k]>minm) {
                    return true;
                }
            }
            minm = Math.min(minm,nums[j]);
        }
        return false;
    }
}