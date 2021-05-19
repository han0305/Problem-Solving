/* Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums. */

class Solution {
    public int[] runningSum(int[] nums) {
        
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            res[i] = nums[i] + res[i-1];
        }
        return res;
    }
}