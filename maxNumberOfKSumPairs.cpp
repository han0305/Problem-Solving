/* You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array. */

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int left = 0;
        int right = nums.size()-1;
        int ops = 0;
        while(left<right) {
            int sum = nums[left]+nums[right];
            if(sum == k) {
                ops++;
                left++;
                right--;
            }
            else if(sum<k) {
                left++;
            }
            else {
                right--;
            }
            
        }
        return ops;
    }
};