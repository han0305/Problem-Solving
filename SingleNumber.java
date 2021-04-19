/* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory? */

class Solution {
    public int singleNumber(int[] nums) {
        
        int res = nums[0];
        int i=1;
        while(i<nums.length) {
            
            res=res^nums[i++];
        }
        
        return res;
    }
}