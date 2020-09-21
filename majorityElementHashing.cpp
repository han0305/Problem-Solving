/* Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array. */

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        unordered_map<int,int> umap;
        int maxCount = INT_MIN;
        int majorityEle;
        int n = nums.size();
        
        for(int i=0;i<n;i++) {
            
            if(umap.find(nums[i]) == umap.end()) {
                umap[nums[i]] = 1;
            }
            else 
                umap[nums[i]]++;
            if(umap[nums[i]]>maxCount) {
                maxCount = umap[nums[i]];
                majorityEle = nums[i];
            }
            
        }
    
        return majorityEle;
        
        
    }
};