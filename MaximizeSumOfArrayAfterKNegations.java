/* Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way. */

class Solution {
    public int largestSumAfterKNegations(int[] A, int k) {
        Arrays.sort(A);
        int sum = 0;
        int i = 0;
        while(i<A.length && A[i]<0) {
            if(i+1<A.length && A[i+1] >= 0 && k>0) {
                if(k%2!=0) {
                    sum+=(-1*A[i]);
                }
                else {
                    if(A[i+1] <= Math.abs(A[i])) {
                        A[i+1] = -1 * A[i+1];
                        sum+=(-1*A[i]);
                    }
                    else {
                        sum+=A[i];
                    }
                }
                k=0;
            }
            else if(k>0) {
                sum+=(-1*A[i]);
                k--;
            }
            else {
                sum+=A[i];
            }
            i++;
        }
        while(i<A.length) {
            if(k%2!=0) {
                
                sum+=(-1*A[i]);
                k=0;
            }
            else {
                sum+=A[i];
            }
            i++;
        }
        
        return sum;
        
    }
}