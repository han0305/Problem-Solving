/* A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order. */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        int[][] dp = new int[2][n];
        int maxm = 1;
        
        for(int i=0;i<n;i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
            for(int j=0;j<i;j++) {
                int diff = nums[i]-nums[j];
                if(diff<0) {
                    dp[0][i] = Math.max(dp[0][i],1+dp[1][j]);
                }
                else if(diff >0){
                     dp[1][i] = Math.max(dp[1][i],1+dp[0][j]);
                }
            }
            maxm = Math.max(maxm,Math.max(dp[0][i],dp[1][i]));
        }
        
        return maxm;
    }
}