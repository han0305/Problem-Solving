/* Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order. */

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> freq = new TreeMap<Integer,Integer>();
        for(int i=0;i<arr1.length;i++) {
            int curr = freq.getOrDefault(arr1[i],0);
            freq.put(arr1[i],++curr);
        }
        int j=0;
        int[] res = new int[arr1.length];
        for(int i=0;i<arr2.length;i++) {
            int curr = freq.getOrDefault(arr2[i],0);
            while(curr>0) {
                res[j++] = arr2[i];
                curr--;
            }
            freq.remove(arr2[i]);
        }
        for(Map.Entry m:freq.entrySet()) {
            int no = (int)m.getKey();
            int curr = (int)m.getValue();
            while(curr>0) {
                res[j++] = no;
                curr--;
            }
        }
        return res;
    }
}