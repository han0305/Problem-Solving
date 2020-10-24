/* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. */

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int l = nums.size();
        if(l==0) {
            return 0;
        }
        int maxCount = 1;
        int count = 1;
        for(int i=1;i<l;i++) {
            
            if(nums[i] == nums[i-1] + 1) {
                count++;
            }
            else if(nums[i] == nums[i-1]) {
               if(i == l-1) {
               maxCount = max(count,maxCount); 
               } 
                continue;
            }
            else {
                maxCount = max(count,maxCount);
                count = 1;
            }
            if(i == l-1) {
               maxCount = max(count,maxCount); 
            }
            
        }
        return maxCount;
    }
};