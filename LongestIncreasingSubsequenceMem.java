/* Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. */

class Solution {
    private int maxm = Integer.MIN_VALUE;
    private int getLongest(int[] nums, int start, int[] mem) {
        int curr = nums[start];
        int count = 1;
        for(int i=start+1;i<nums.length;i++) {
            if(curr<nums[i]) {
                if(mem[i] == 0) {
                    mem[i] = getLongest(nums,i,mem);
                }
                count = Math.max(count,1+mem[i]);
            }
            else if(mem[i]==0){
                mem[i] = getLongest(nums,i,mem);
            }
        }
        mem[start] = count;
        maxm = Math.max(maxm,count);
        return count;
    }
    public int lengthOfLIS(int[] nums) {
        int[] mem = new int[nums.length];
        getLongest(nums,0,mem);
        return maxm;
    }
}