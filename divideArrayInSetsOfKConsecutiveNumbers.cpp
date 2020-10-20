/* Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False. */


class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        int l  = nums.size();
        unordered_map<int,int> freq;
        
        for(int i=0;i<l;i++) {
            
            freq[nums[i]]++; 
        }
        bool isPossible = true;
        int count = 0;
        sort(nums.begin(),nums.end());
        for(int i = 0;i<l;i++) {
            
           if(freq[nums[i]] > 0)  {
           count = 1;
           for(int j=1;j<k;j++) {
              
               if(freq.find(nums[i]+j)!=freq.end() && freq[nums[i]+j] > 0) {
                       freq[nums[i]+j]--;
                       count++;
               }
               else {
                   break;
               }
           }
            freq[nums[i]]--;
            isPossible = count == k;
            if(!isPossible)
                break;
          }
         }
        
        return isPossible;
    }
};