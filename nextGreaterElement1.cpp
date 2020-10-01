/* You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.  */


class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        int l1 = nums1.size();
        int l2 = nums2.size();
        vector<int> res;
        int j = l2-1;
        for(int i=0;i<l1;i++) {
            int maxm = -1;
            int j = l2-1;
            while(j>=0 && nums1[i]!=nums2[j]) {
                if(nums2[j]>nums1[i])
                    maxm = nums2[j];
                 j--;
            }
            
            res.push_back(maxm);
        }
        return res;
    }
};