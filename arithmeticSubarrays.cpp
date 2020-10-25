/* A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise. */

class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        
        int ql = l.size();
        vector<bool> res;
        for(int i=0;i<ql;i++) {
            int start = l[i];
            int end = r[i];
            vector<int> temp;
            copy(nums.begin()+start,nums.begin()+end+1,back_inserter(temp));
            sort(temp.begin(),temp.end());
            int diff = temp[1]-temp[0];
            bool isArithmetic = true;
            for(int j=2;j<temp.size();j++) {
                if(temp[j]-temp[j-1]!=diff) {
                    isArithmetic = false;
                    break;
                }
            }
            res.push_back(isArithmetic);
        }
        
        return res;
    }
};