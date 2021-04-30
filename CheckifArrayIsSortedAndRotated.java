/* Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation. */

class Solution {
    public boolean check(int[] nums) {
        
        int decCount = 0;
        
        for(int i=1;i<nums.length;i++) {
            
            if(nums[i]<nums[i-1]) {
                
                decCount++;
            }
            if(decCount>1) {
                
                return false;
            }
        }
        
        if(nums[nums.length-1] > nums[0]) {
            
            decCount++;
        }
        
        if(decCount <= 1) {
            
            return true;
        }
        else {
            
            return false;
        }
    }
}