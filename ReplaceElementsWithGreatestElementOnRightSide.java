/* Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array. */

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int maxm = -1;
        for(int i=n-1;i>=0;i--) {
            res[i] = maxm;
            maxm=Math.max(maxm,arr[i]);
        }
        
        return res;
    }
}