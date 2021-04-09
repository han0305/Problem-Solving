/* A conveyor belt has packages that must be shipped from one port to another within D days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days. */

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i=0;i<weights.length;i++) {
            start = Math.max(start,weights[i]);
            end+=weights[i];
        }
        int minCap = 0;
        while(start<=end) {
            
            int cap = (start+end)/2;
            int currCap = 0;
            int count = 0;
            for(int i=0;i<weights.length;i++) {
                if(currCap + weights[i] > cap) {
                    count++;
                    currCap = weights[i];
                }
                else {
                    currCap+=weights[i];
                }
                if(i == weights.length-1 && currCap>0) {
                    count++;
                }
                
            }
            
            if(count<=D) {
                minCap = cap; 
                end = cap-1;
            }
            else {
                start = cap+1;
            }
            
        }
        
        return minCap;
    }
}