/* A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Follow up: Your solution should be in logarithmic complexity. */

class Solution {
public:
    
    int findPeakElement(vector<int>& nums) {
        int end = nums.size()-1;
        int start = 0;
        if(end==0) {
            return 0;
        }
        while(start<end) {
            
            int mid = (start+end)/2;
            
            if(nums[mid]<nums[mid+1]) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
       return start;        
        
    }
};