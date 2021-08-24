/* A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level  i.e.  time[i]*satisfaction[i]

Return the maximum sum of Like-time coefficient that the chef can obtain after dishes preparation.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value. */

class Solution {
    private int getMaxSatisfaction(int[] satisfaction, int idx, int time, int[][] mem) {
        if(idx == satisfaction.length) {
            return 0;
        }
        if(mem[idx][time]!=Integer.MIN_VALUE) {
            return mem[idx][time];
        }
        return mem[idx][time] = Math.max(getMaxSatisfaction(satisfaction, idx+1, time, mem), time*satisfaction[idx]+getMaxSatisfaction(satisfaction, idx+1,time+1, mem));
    }
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n+1][n+2];
        for(int i=n-1;i>=0;i--) {
            for(int j=n;j>=1;j--) {
                dp[i][j] = Math.max(satisfaction[i]*j+dp[i+1][j+1],dp[i+1][j]);
            }
        }
        
        return dp[0][1];
    }
}