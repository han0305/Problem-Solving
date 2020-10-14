/* A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞. */

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l = nums.size();
        if(l==1) {
            return 0;
        }
        for(int i=0;i<l;i++) {
            
            if(i == 0) {
                if(nums[i]>nums[i+1])
                    return i;
            }
            else if(i == l-1) {
                if(nums[i]>nums[i-1])
                    return i;
            }
            else if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) {
                return i;
            }
            
        }
        return -1;
    } 
};