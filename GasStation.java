/* There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int d = 0;
        int s = 0;
        
        for(int i=0;i<gas.length;i++) {
            
            if(s+gas[i] < cost[i]) {
                d = d + (cost[i] - (s+gas[i]));
                s = 0;
                start = i+1;
            }
            else {
                s = (s+gas[i]) - cost[i];
            }
            
            
        }
        
        return s-d>=0?start:-1;
    }
}