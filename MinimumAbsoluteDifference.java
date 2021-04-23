/* Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        int minm = Integer.MAX_VALUE;
        
        for(int i=1;i<arr.length;i++) {
            
            minm = Math.min(minm,arr[i]-arr[i-1]);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=1;i<arr.length;i++) {
            
            if(arr[i]-arr[i-1] == minm) {
                ArrayList<Integer> curr = new ArrayList<Integer>();
                curr.add(arr[i-1]);
                curr.add(arr[i]);
                res.add(curr);
            } 
        }
        
        return res;
    }
}