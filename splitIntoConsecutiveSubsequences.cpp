/* Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3. */

class Solution {
public:
    bool isPossible(vector<int>& nums) {
        unordered_map<int,int> cnt,end;
        int l = nums.size();
        
        for(int i=0;i<l;i++) {
            cnt[nums[i]]++;
        }
        
        for(int i=0;i<l;i++) {
            if(cnt[nums[i]] > 0) {
                if(end[nums[i]-1] > 0) {
                    end[nums[i]-1]--;
                    end[nums[i]]++;
                    cnt[nums[i]]--;
                }
                else if(cnt[nums[i]+1]>0 && cnt[nums[i]+2]>0) {
                     cnt[nums[i]]--;
                     cnt[nums[i]+1]--;
                     cnt[nums[i]+2]--;
                     end[nums[i]+2]++;
                    
                }
                else {
                    return false; 
                }
                
            }
            
        }
        return true;
    }
};