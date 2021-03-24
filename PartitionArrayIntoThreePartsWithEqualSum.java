/* Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) */

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
        }
        if(sum%3!=0)
            return false;
        int count = 0;
        sum = sum/3;
        int currSum = 0;
        for(int i=0;i<arr.length;i++) {
            currSum+=arr[i];
            if(currSum == sum) {
                currSum = 0;
                count++;
            }
        }
        
        return count >= 3;
    }
}