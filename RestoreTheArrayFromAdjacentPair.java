/* There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.

You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.

It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.

Return the original array nums. If there are multiple solutions, return any of them. */

class Solution {
    
    private void dfs(int curr,HashMap<Integer,ArrayList<Integer>> graph,int[] res,int idx,HashSet<Integer> visited) {
        
        res[idx++] = curr;
        visited.add(curr);
        ArrayList<Integer> adjacent = graph.get(curr);
        for(int i=0;i<adjacent.size();i++) {
            if(!visited.contains(adjacent.get(i))) {
                dfs(adjacent.get(i),graph,res,idx,visited);
            }
            
        }
        
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<adjacentPairs.length;i++) {
            int n1 = adjacentPairs[i][0];
            int n2 = adjacentPairs[i][1];
            ArrayList<Integer> l1 = graph.getOrDefault(n1,new ArrayList());
            l1.add(n2);
            graph.put(n1,l1);
            ArrayList<Integer> l2 = graph.getOrDefault(n2,new ArrayList());
            l2.add(n1);
            graph.put(n2,l2);
        }
        int[] res = new int[graph.size()];
        HashSet<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer,ArrayList<Integer>> m : graph.entrySet()) {
            if(m.getValue().size() == 1) {
              dfs(m.getKey(),graph,res,0,visited);
              break;
          }
            
        }
        return res;
    }
}