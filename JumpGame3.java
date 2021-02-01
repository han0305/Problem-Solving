/* Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time. */

class Solution {
    
    private boolean canReachUtil(int[] arr,int curr,boolean[] visited) {
        
        if(arr[curr] == 0)
            return true;
        boolean res = false;
        if(curr+arr[curr] < arr.length && !visited[curr+arr[curr]]) {
            visited[curr+arr[curr]]=true;
            res = res || canReachUtil(arr,curr+arr[curr],visited);
        }
        if(curr-arr[curr] >= 0 && !visited[curr-arr[curr]]) {
            visited[curr-arr[curr]]=true;
            res = res || canReachUtil(arr,curr-arr[curr],visited);
        }
        return res;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return canReachUtil(arr,start,visited);
    }
}