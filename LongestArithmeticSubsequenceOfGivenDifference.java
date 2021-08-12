/* Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements. */

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int[] dp = new int[arr.length];
        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxm = 0;
        for(int i=0;i<arr.length;i++) {
            int key = arr[i]-difference;
            dp[i] = hm.getOrDefault(key,0)+1;
            hm.put(arr[i],dp[i]);
            maxm = Math.max(maxm,dp[i]);
        }
        return maxm;
    }
}