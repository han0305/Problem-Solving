/* You are given a series of video clips from a sporting event that lasted time seconds. These video clips can be overlapping with each other and have varying lengths.

Each video clip is described by an array clips where clips[i] = [starti, endi] indicates that the ith clip started at starti and ended at endi.

We can cut these clips into segments freely.

For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event [0, time]. If the task is impossible, return -1. */

class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time+1];
        Arrays.fill(dp, clips.length+1);
        dp[0] = 0;
        
        for(int i=0;i<dp.length;i++) {
            for(int[] clip : clips) {
                int start = clip[0];
                int end = clip[1];
                if(i>=start && i<=end) {
                    dp[i] = Math.min(dp[i],dp[start]+1);
                }
            }
        }
        
        return dp[time] == clips.length+1?-1:dp[time];
    }
}