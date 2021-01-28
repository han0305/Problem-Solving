/* You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order. */

class CustomSort implements Comparator<int[]> {
    @Override
    public int compare(int[] a,int[] b) {
        return a[0]-b[0];
    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        
        int n = pairs.length;
        int[] dp = new int[n];
        int maxm = 0;
        Arrays.sort(pairs,new CustomSort());
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(pairs[i][0] > pairs[j][1] ) {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    
                }
            }
            maxm = Math.max(maxm,dp[i]);
        }
        return maxm;
    }
}