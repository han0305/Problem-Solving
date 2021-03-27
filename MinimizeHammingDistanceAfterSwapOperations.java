/* You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.

The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).

Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source. */

class Solution {
    
    private void dfs(int idx,HashMap<Integer,List<Integer>> graph,int[] source, int[] target, HashMap<Integer,Integer> sourceComponent,HashMap<Integer,Integer> targetComponent,HashSet<Integer> visited) {
        
        visited.add(idx);
        if(source[idx] != target[idx]) {
            if(sourceComponent.containsKey(target[idx]) && sourceComponent.get(target[idx])>0) {
                int freq = sourceComponent.get(target[idx]);
                freq--;
                sourceComponent.put(target[idx],freq);
            }
            else {
                int freq = targetComponent.getOrDefault(target[idx],0);
                freq++;
                targetComponent.put(target[idx],freq);
            }
            if(targetComponent.containsKey(source[idx]) && targetComponent.get(source[idx])>0) {
                int freq = targetComponent.get(source[idx]);
                freq--;
                targetComponent.put(source[idx],freq);
            }
            else {
                int freq = sourceComponent.getOrDefault(source[idx],0);
                freq++;
                sourceComponent.put(source[idx],freq);
            }
            
        }
        
        if(graph.containsKey(idx)){
        List<Integer> edges = graph.get(idx);
        
        for(int i=0;i<edges.size();i++) {
            int curr = edges.get(i);
            if(visited.contains(curr))
                continue;
            dfs(curr,graph,source,target,sourceComponent,targetComponent,visited);
        }
        }
    }
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<allowedSwaps.length;i++)  {
            
            List<Integer> edges = graph.getOrDefault(allowedSwaps[i][0],new ArrayList<Integer>());
            edges.add(allowedSwaps[i][1]);
            graph.put(allowedSwaps[i][0],edges);
            
            edges = graph.getOrDefault(allowedSwaps[i][1],new ArrayList<Integer>());
            edges.add(allowedSwaps[i][0]);
            graph.put(allowedSwaps[i][1],edges);
            
        }
        
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0;i<source.length;i++) {
            if(visited.contains(i))
                continue;
            HashMap<Integer,Integer> sourceComponent = new HashMap<>();
             HashMap<Integer,Integer> targetComponent = new HashMap<>();
            dfs(i,graph,source,target,sourceComponent,targetComponent,visited);
            
            for(Map.Entry<Integer,Integer> m : targetComponent.entrySet()) {
                count+=m.getValue();
            }
            
            
        }
        
        
        return count;
        
    }
}