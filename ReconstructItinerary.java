/* You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once. */

class Solution {
    private void getItinerary(String src,  HashMap<String, PriorityQueue<String>> graph,   LinkedList<String> res) {
        PriorityQueue<String> pq = graph.get(src);
        while(pq!=null && !pq.isEmpty()) {
            String dest = pq.poll();
            
            getItinerary(dest, graph, res);
        }
        res.addFirst(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> pair : tickets) {
            String src = pair.get(0);
            String dest = pair.get(1);
            PriorityQueue<String> pq = graph.getOrDefault(src, new PriorityQueue<>((s1,s2)-> s1.compareTo(s2)));
            pq.offer(dest);
            graph.put(src,pq);
        }
        LinkedList<String> res = new LinkedList<>();
        getItinerary("JFK", graph, res);
        return res;
    }
}