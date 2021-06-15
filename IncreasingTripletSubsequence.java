/* Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false. */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<low) {
                low = nums[i];
            }
            else if(nums[i]>low && nums[i]<mid) {
                mid = nums[i];
            }
            else if(nums[i] > mid) {
                return true;
            }
        }
        
        return false;
    }
}