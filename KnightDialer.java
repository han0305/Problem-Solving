/* The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 10^9 + 7. */

class Solution {
    public int knightDialer(int n) {
        int mod = 1000000007;
        int[][] moves = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[1],1);
        
        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                for(int k = 0;k<moves[j].length;k++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][moves[j][k]])%mod;
                }
            }
        }
        
        int sum = 0;
        for(int i=0;i<dp[n].length;i++) {
            sum=(sum+dp[n][i])%mod;
        }
        return sum;
    }
}