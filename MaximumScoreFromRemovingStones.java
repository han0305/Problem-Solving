/* You are playing a solitaire game with three piles of stones of sizes a​​​​​​, b,​​​​​​ and c​​​​​​ respectively. Each turn you choose two different non-empty piles, take one stone from each, and add 1 point to your score. The game stops when there are fewer than two non-empty piles (meaning there are no more available moves).

Given three integers a​​​​​, b,​​​​​ and c​​​​​, return the maximum score you can get. */

class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer n1,Integer n2) -> n2-n1);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        int res = 0;
        while(pq.size()>=2) {
            
            int n1 = pq.poll();
            int n2 = pq.poll();
            n1--;
            n2--;
            if(n1>0)
                pq.offer(n1);
            if(n2>0)
                pq.offer(n2);
            res++;
            
        } 
        
        return res;
        
    }
}