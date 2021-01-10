/* You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */

class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int waysFromLast = 2;
        int waysFromSecondLast = 1;
        
        for(int i=3;i<=n;i++) {
            int totalWays = waysFromLast + waysFromSecondLast;
            waysFromSecondLast = waysFromLast;
            waysFromLast = totalWays;
            
        }
        
        return waysFromLast;
    }
}