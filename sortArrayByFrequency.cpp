/* Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array. */

unordered_map<int,int> umap;
bool compFunc(int a,int b) {
    if(umap[a]<umap[b]) {
        return true;
    }
    else if(umap[a] == umap[b]) {
        return a>b;
    }
    return false;
}
class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        
        for(int i=0;i<nums.size();i++) {
            umap[nums[i]]++;
        }
        sort(nums.begin(),nums.end(),compFunc);
        umap.clear();
        return nums;
    }
};