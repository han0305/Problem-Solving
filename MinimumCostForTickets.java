/* You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days. */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] passDays = {1,7,30}, dp = new int[days.length];
        
        for(int i=0;i<days.length;i++) {
            int minm = Integer.MAX_VALUE;
            for(int j=0;j<3;j++) {
                int day = passDays[j];
                int cost = costs[j];
                int idx = i-1;
                int window = days[i] - day;
                while(idx>=0 &&  days[idx]>window) {
                    idx--;
                }
                minm = idx>=0?Math.min(minm,cost+dp[idx]):Math.min(minm,cost);
            }
            dp[i] = minm;
        }
        return dp[days.length-1];
    }
}