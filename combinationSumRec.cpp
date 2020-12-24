/* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different. */

class Solution {
public:
    
    void getCombinations(vector<int> candidates,vector<vector<int>>& res,int n,int sum,int start,int target,vector<int> temp) {
        
        if(sum == target) {
            res.push_back(temp);
            return;
        }
        if(sum > target) {
            return;
        }
        for(int i = start;i<n;i++) {
            sum = sum + candidates[i];
            temp.push_back(candidates[i]);
            getCombinations(candidates,res,n,sum,i,target,temp);
            temp.pop_back();
            sum = sum-candidates[i];
        }
        
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
       int n = candidates.size();
       vector<vector<int>> res;
       vector<int> temp;
       getCombinations(candidates,res,n,0,0,target,temp);
       return res;
    }
};