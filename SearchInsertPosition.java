/* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. */

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int idx = -1;
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end) {
            
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                idx = mid;
                break;
            }
            else if(nums[mid]>target) {
                idx = mid;
                end=mid-1;
            }
            else if(nums[mid]<target) {
                idx=mid+1;
                start=mid+1;
            }
            
            
        }
        
        return idx;
    }
}