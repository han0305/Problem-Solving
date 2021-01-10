/* Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one. */

class Solution {
    public int maxProfit(int[] prices) {
        int minm = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i<prices.length;i++) {
            if(prices[i]<minm) {
                minm = prices[i];
            }
            else {
                res = Math.max(res,prices[i] - minm);
            }
        }
        return res;
    }
}