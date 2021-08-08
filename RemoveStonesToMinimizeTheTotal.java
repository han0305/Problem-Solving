/* You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down). */

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> b-a);
        for(int pile : piles) {
            pq.offer(pile);
        }
        while(k>0) {
            int pile = pq.poll();
            pile-= (int)Math.floor(pile/2);
            pq.offer(pile);
            k--;
        }
        int sum = 0;
        while(!pq.isEmpty()) {
            sum+=pq.poll();
        }
        return sum;
    }
}