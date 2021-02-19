/* There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.  */

class Solution {
    public int[] findBuildings(int[] heights) {
        
        int maxm = Integer.MIN_VALUE;
        ArrayList<Integer> idx = new ArrayList<>();
        for(int i=heights.length-1;i>=0;i--) {
            if(heights[i]>maxm) {
                maxm = heights[i];
                idx.add(i);
            }
        }
        int[] res = new int[idx.size()];
        int j = idx.size()-1;
        for(int i=0;i<idx.size();i++) {
            res[j--] = idx.get(i);
        }
        return res;
    }
}