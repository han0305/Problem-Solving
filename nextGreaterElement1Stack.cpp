/* You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number. */

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        int l1 = nums1.size();
        int l2 = nums2.size();
        stack<int> st;
        unordered_map<int,int> nextMax;
        
        for(int i=0;i<l2;i++) {
            
            while(!st.empty() && nums2[i]>st.top()) {
                nextMax[st.top()] = nums2[i];
                st.pop();
            }
            st.push(nums2[i]);
        }
        while(!st.empty()) {
            
            nextMax[st.top()] = -1;
            st.pop();
        }
        
        vector<int> res;
        for(int i=0;i<l1;i++) {
            res.push_back(nextMax[nums1[i]]);
            
        }
        return res;
    }
};