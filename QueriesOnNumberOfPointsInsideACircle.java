/* You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query. */

class Solution {
    
    private boolean isInside(int x1, int y1, int x2, int y2,int r) {
        
        int dist = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        
        return dist<=r*r;
        
    }
    
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] res = new int[queries.length];
        int i = 0;
        
        while(i<queries.length) {
            
            for(int j=0;j<points.length;j++) {
                
                if(isInside(queries[i][0],queries[i][1],points[j][0],points[j][1],queries[i][2]) == true) {
                    
                    res[i]++;
                    
                }
                
            }
            
            i++;
            
        }
        
        return res;
    }
}