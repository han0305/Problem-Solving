/* There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:

In each step, you will choose any 3 piles of coins (not necessarily consecutive).
Of your choice, Alice will pick the pile with the maximum number of coins.
You will pick the next pile with maximum number of coins.
Your friend Bob will pick the last pile.
Repeat until there are no more piles of coins.
Given an array of integers piles where piles[i] is the number of coins in the ith pile.

Return the maximum number of coins which you can have. */

class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        int start = 0;
        int end = piles.length-1;
        int res = 0;
        
        while(start<end-1) {
            
            res+=piles[end-1];
            start++;
            end-=2;
            
        }
        
        return res;
    }
}