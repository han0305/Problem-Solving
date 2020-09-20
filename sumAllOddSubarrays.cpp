/* Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr. */

class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        int n = arr.size();
        if(n==0) {
            return 0;
        }
        vector<int> cum(n);
        int sum = 0;
        cum[0] = arr[0];
        for(int i=1;i<n;i++) {
            cum[i] = arr[i]+cum[i-1];
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if((i-j+1)%2!=0) {
                    if(j-1>=0) {
                        sum = sum+cum[i]-cum[j-1];
                    }
                    else {
                        sum = sum+cum[i];
                    }
                }
                
            }
            
        }
        return sum;
    }
};