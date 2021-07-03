/* Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one element, or false otherwise. If the array is already strictly increasing, return true.

The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length). */

class Solution {
    public boolean canBeIncreasing(int[] nums) {
     
        
        int count = 0;
        int last = 0;
        for(int i=1;i<nums.length;i++) {
            int j = last;
            int currCount = 0;
            while(j>=0 && nums[i]<=nums[j--]) {
                currCount++;
            }
            if(currCount<=1) {
                last = i;
            }
            count = currCount == 0 ? count : count+1;
            if(count>1)
                break;
        }
        
        return count<=1;
    }
}