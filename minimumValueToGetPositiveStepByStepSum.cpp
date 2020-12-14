/* Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1. */

class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int minm = 0;
        int sum = 0;
        for(int i=0;i<nums.size();i++) {
            sum = sum + nums[i];
            if(sum<=0) {
                minm = minm+abs(sum)+1;
                sum=1;
            }
            
        }
        return minm==0?1:minm;
    }
};