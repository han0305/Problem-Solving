/* Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1. */

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> hm  = new HashMap<>();
        int maxm = -1;
        
        for(int i=0;i<arr.length;i++) {
            int count = hm.getOrDefault(arr[i],0);
            count++;
            hm.put(arr[i],count);
            
        }
        
        for(Map.Entry<Integer,Integer> m : hm.entrySet()) {
            int key = m.getKey();
            int val = m.getValue();
            if(key == val)
                maxm = Math.max(maxm,key);
            
        }
        
        return maxm;
    }
}