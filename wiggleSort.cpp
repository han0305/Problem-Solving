/* Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3].... */

class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int l = nums.size();
        int j = l%2==0?l/2:l/2+1;
        int i=1;
        while(i<j && j<l) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i+=2;
            j++;
        }
        
    }
};