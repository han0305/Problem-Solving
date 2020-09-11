/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?*/

class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res;
        for(int i=0;i<n;i++) {
            int no = nums[abs(nums[i])-1];
            if(no < 0) {
                res.push_back(abs(nums[i]));
            }
            else {
                nums[abs(nums[i])-1] = no * -1;
            }
        }
        return res;
    }
};