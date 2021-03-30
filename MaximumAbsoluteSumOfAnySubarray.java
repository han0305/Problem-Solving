/* You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x. */

class Solution {
    
    public int maxAbsoluteSum(int[] nums) {
        
        int maxm = nums[0];
        int minm = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        
        for(int i=1;i<nums.length;i++) {
            
            if(currMax+nums[i]<=nums[i]) {
                currMax = nums[i];
                currMin = currMin+nums[i];
            }
            else {
                currMax = currMax+nums[i];
                currMin = nums[i];
            }
            
            maxm = Math.max(maxm,currMax);
            minm = Math.min(minm,currMin);
            
        }
        
        return Math.max(Math.abs(maxm),Math.abs(minm));
    }
}