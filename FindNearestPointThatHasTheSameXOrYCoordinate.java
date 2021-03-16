/* You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y). You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi). A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.

Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location. If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.

The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2). */

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int minDist = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        
        for(int i=0;i<points.length;i++) {
            
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            if(x == x1 || y == y1) {
                
                int dist = Math.abs(x-x1) + Math.abs(y-y1);
                if(dist <= minDist) {
                    
                    if(dist == minDist) {
                        minIdx = Math.min(minIdx,i);
                    }
                    else {
                        minDist = dist;
                        minIdx = i;
                    }
                }
            }
            
        }
        
        return minIdx == Integer.MAX_VALUE ? -1:minIdx;
    }
}