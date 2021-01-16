/* You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin. */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
             }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}