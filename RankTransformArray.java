/* Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible. */

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int rank = 1;
        for(int i=0;i<temp.length;i++) {
            if(!hm.containsKey(temp[i])) {
                hm.put(temp[i],rank);
                rank++;
            }
        }
        for(int i=0;i<arr.length;i++) {
            rank = hm.get(arr[i]);
            temp[i] = rank;
        }
        
        return temp;
        
    }
}