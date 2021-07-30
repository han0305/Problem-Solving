/* Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays. */

class Solution {
    private int getLargestMinSum(int[] nums, int m, int idx, int count,int mem[][]) {
        if(idx == nums.length) {
            return 0;
        }
        if(count == m) {
            return Integer.MAX_VALUE;
        }
        if(mem[idx][count]!=-1) {
            return mem[idx][count];
        }
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=idx;i<nums.length-(m-(count+1));i++) {
            sum+=nums[i];
            minSum = Math.min(minSum, Math.max(sum,getLargestMinSum(nums,m,i+1,count+1,mem)));
        }
        mem[idx][count] = minSum;
        return mem[idx][count];
    }
    public int splitArray(int[] nums, int m) {
        int[][] mem = new int[nums.length][m];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<m;j++) {
                mem[i][j] = -1;
            }
        }
        return getLargestMinSum(nums,m,0,0,mem);
    }
}