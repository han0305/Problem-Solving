/* You are given an integer array nums sorted in ascending order (not necessarily distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,4,4,5,6,6,7] might become [4,5,6,6,7,0,1,2,4,4]).

If target is found in the array return its index, otherwise, return -1. */

class Solution {
    public boolean search(int[] nums, int target) {
        
       int end = nums.length-1;
       int start = 0;
       
        while(start<=end) {
            
            int mid = (start+end)/2;
            System.out.println(mid);
            if(target == nums[mid])
                return true;
            if(nums[mid] == nums[start]) {
                start++;
            }
            else if(nums[mid]>nums[start]) {
                if(target < nums[start])
                    start = mid+1;
                else if(target == nums[start])
                    return true;
                else if(target > nums[start] && target < nums[mid]) 
                    end = mid-1;
                else
                    start = mid+1;
            
            }
            else if(nums[mid]<nums[start]){
                if(target > nums[start])
                    end = mid-1;
               else if(target == nums[start])
                    return true;
               else if(target < nums[start] && target < nums[mid]) 
                    end = mid-1;
                else
                    start = mid+1;
            }
        }
        
       return false; 
        
    }
}