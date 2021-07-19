/* You are given a strictly increasing integer array rungs that represents the height of rungs on a ladder. You are currently on the floor at height 0, and you want to reach the last rung.

You are also given an integer dist. You can only climb to the next highest rung if the distance between where you are currently at (the floor or on a rung) and the next rung is at most dist. You are able to insert rungs at any positive integer height if a rung is not already there.

Return the minimum number of rungs that must be added to the ladder in order for you to climb to the last rung. */

class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int prev = 0;
        int res = 0;
        int i=0;
        while(i<rungs.length) {
            if(prev+dist<rungs[i]) {
                res=res+(rungs[i]-prev-1)/dist;
            }
            
             prev = rungs[i];
             i++;
        
        }
        return res;
    }
}