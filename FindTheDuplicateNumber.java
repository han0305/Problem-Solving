/* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number. */

class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i=0;i<nums.length;i++) {
            
            if(nums[Math.abs(nums[i])]<0) {
                
                return Math.abs(nums[i]);
            }
            
            nums[Math.abs(nums[i])] = -1*nums[Math.abs(nums[i])];
        }
        
        return -1;
    }
}