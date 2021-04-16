/* In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 */

 class Solution {
    public int repeatedNTimes(int[] A) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        
        for(int i=0;i<A.length;i++) {
            int currFreq = hm.getOrDefault(A[i],0)+1;
            hm.put(A[i],currFreq);
        }
        
        int res = -1;
        
        for(Map.Entry<Integer,Integer> mp:hm.entrySet()) {
            
            int key = mp.getKey();
            int val = mp.getValue();
            
            if(val==A.length/2) {
                res = key;
                break;
            }
            
            
        }
        
        return res;
    }
}