/* You are given an integer n. An array nums of length n + 1 is generated in the following way:

nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums​​​. */

class Solution {
public:
    int getMaximumGenerated(int n) {
        if(n==0) {
            return 0;
        }
        vector<int> no(n+1);
        int maxm = INT_MIN;
        if(n==1) {
            return 1;
        }
        no[0]=0;
        no[1]=1;
        for(int i=2;i<=n;i++) {
            int ind = i/2;
            if(i%2 == 0)
            no[i] = no[ind];
            else
            no[i] = no[ind]+no[ind+1];
            maxm = max(no[i],maxm);
        }
        return maxm;
    }
};