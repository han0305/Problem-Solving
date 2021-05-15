/* There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph. */

class Solution {
    public int findCenter(int[][] edges) {
        
        int[] freq = new int[edges.length+1];
        int res = 0;
        for(int i=0;i<edges.length;i++) {
            freq[edges[i][0]-1]++;
            if(freq[edges[i][0]-1] > 1) {
                res = edges[i][0];
                break;
            }
            freq[edges[i][1]-1]++;
            if(freq[edges[i][1]-1] > 1) {
                res = edges[i][1];
                break;
            }
        }
        return res;
    }
}