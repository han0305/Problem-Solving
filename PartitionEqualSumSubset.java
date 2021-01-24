/* Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal. */

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int m = nums.length;
        int n = sum/2;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(j-nums[i-1]>=0) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else 
                dp[i][j] = dp[i][j] || dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}