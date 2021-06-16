/* You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array. */

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];
        
        for(int i=0;i<nums.length;i++) {
            lis[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j] && lis[i]<1+lis[j]) {
                    lis[i] = 1+lis[j];
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--) {
            lds[i] = 1;
            for(int j=nums.length-1;j>i;j--) {
                if(nums[i]>nums[j] && lds[i]<1+lds[j]) {
                    lds[i] = 1+lds[j];
                }
            }
           if(lis[i]>1 && lds[i]>1)
            res = Math.min(res,nums.length-(lis[i]+lds[i]-1));
        }
        
        return res;
    }
}