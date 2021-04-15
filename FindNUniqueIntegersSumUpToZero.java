/* Given an integer n, return any array containing n unique integers such that they add up to 0. */

class Solution {
    public int[] sumZero(int n) {
        
        int[] res = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++) {
            if(i == n-1) {
                res[i] = -1*sum;
                break;
            }
            res[i] = i+1;
            sum+=i+1;
        }
        
        return res;
    }
}