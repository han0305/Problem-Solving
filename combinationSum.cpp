/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.*/

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