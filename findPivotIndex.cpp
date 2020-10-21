/* Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index. */

class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        
        int l = nums.size();
        vector<int> rightSum(l+1,0);
        
        for(int i=l-1;i>=0;i--) {
            
            rightSum[i] = nums[i]+rightSum[i+1];
            
        }
        
        int leftSum = 0;
        int ans = -1;
        for(int i=0;i<l;i++) {
            
            if(leftSum == rightSum[i+1]) {
                ans = i;
                break;
            }
            leftSum+=nums[i];
        }
        return ans;
    }
};