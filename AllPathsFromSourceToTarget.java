/* Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]). */

class Solution {
    
    private void getAllPaths(int idx, int[][] graph, List<List<Integer>> res, List<Integer> currPath) {

        if(idx == graph.length-1) {
            res.add(new ArrayList<>(currPath));
        }
        for(int i=0;i<graph[idx].length;i++) {
            currPath.add(graph[idx][i]);
            getAllPaths(graph[idx][i], graph, res, currPath);
            currPath.remove(currPath.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currPath = new ArrayList<Integer>();
        currPath.add(0);
        getAllPaths(0, graph, res, currPath);
        
        return res;
        
    }
}