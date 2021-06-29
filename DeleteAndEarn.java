/* You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times. */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        int[] mem = new int[10001];
        for(int i=0;i<nums.length;i++) {
            freq[nums[i]]++;
        }
        int prev = 1;
        int prev1 = freq[1];
        int prev2 = 0;
        for(int i=2;i<freq.length;i++) {
            if(freq[i] == 0) {
                continue;
            }
            if(prev!=i-1) {
                prev2 = prev1;
                prev1 = freq[i]*i+prev1;
            }
            else {
                int currMax = Math.max(freq[i]*i+prev2,prev1);
                prev2 = prev1;
                prev1 = currMax;
            }
            prev = i;
        }
        
        return prev1;
    }
}