/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates. */

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int minm = Integer.MAX_VALUE;
        while(start<=end) {
            
            int mid = (start+end)/2;
            minm = Math.min(nums[mid],minm);
            if(nums[mid]>nums[start]) {
                if(nums[mid]<nums[end]) 
                    end = mid-1;
                else if(nums[mid]>nums[end])
                    start = mid+1;
                else 
                    end = mid-1;
            }
            else if(nums[mid]<nums[start])
                end = mid-1;
            else if(nums[mid] == nums[start]) {
                 start = start+1;
                
                
            }
    }
        
        return minm;
    }
}