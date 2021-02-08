/* Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product. */

class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int start = 0;
        int negCount = 0;
        int firstIdx = -1;
        int lastIdx = -1;
        int maxm = 0;
        
        for(int i=0;i<n;i++) {
            if(nums[i] == 0 && start == i) {
                start++;
            }
            else if(nums[i] == 0) {
                int end = i-1;
                if(negCount%2==0) {
                    maxm = Math.max(maxm,(end-start)+1);
                }
                else {
                    int firstHalfLen = ((lastIdx-1)-start)+1;
                    int secondHalfLen = (end-(firstIdx+1))+1;
                    int currMax = Math.max(firstHalfLen,secondHalfLen);
                    maxm  = Math.max(maxm,currMax);
                }
                start = i+1;
                negCount = 0;
                firstIdx = -1;
                lastIdx = -1;
            }
            else if(nums[i] < 0) {
                lastIdx = i;
                if(firstIdx == -1)
                    firstIdx = i;
                negCount++;
            }
            if(nums[i]!=0 && i == n-1) {
               int end = i;
                if(negCount%2==0) {
                    maxm = Math.max(maxm,(end-start)+1);
                }
                else {
                    int firstHalfLen = ((lastIdx-1)-start)+1;
                    int secondHalfLen = (end-(firstIdx+1))+1;
                    int currMax = Math.max(firstHalfLen,secondHalfLen);
                    maxm  = Math.max(maxm,currMax);
                }
                
           }
        }
        
        return maxm;
    }
}