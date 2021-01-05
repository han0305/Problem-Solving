/* Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them. */

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer,Integer> hm = new HashMap();
        int n = A.length;
        
        for(int i=0;i<n;i++) {
            hm.put(B[i],i);
        }
        int[] res = new int[n];
        
        for(int i=0;i<n;i++) {
            res[i] = hm.get(A[i]);
        }
        return res;
    }
}