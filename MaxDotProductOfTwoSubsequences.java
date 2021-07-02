/* Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

  */

  class Solution {
    private int getMax(int[] nums1, int[] nums2, int idx1, int idx2, int isEmpty, int[][][] mem) {
        
        if(idx1 == 0 || idx2 == 0) {
            return isEmpty == 1?Integer.MIN_VALUE:0;
        }
        if(mem[idx1][idx2][isEmpty]!=Integer.MIN_VALUE) {
            return mem[idx1][idx2][isEmpty];
        } 
        mem[idx1][idx2][isEmpty] =  Math.max(nums1[idx1-1]*nums2[idx2-1] + getMax(nums1,nums2,idx1-1,idx2-1, 0,mem), Math.max(getMax(nums1,nums2,idx1,idx2-1,isEmpty,mem),getMax(nums1,nums2,idx1-1,idx2,isEmpty,mem)));
        
        return mem[idx1][idx2][isEmpty];
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][][] mem = new int[nums1.length+1][nums2.length+1][2];
        for(int i=1;i<=nums1.length;i++) {
            for(int j=1;j<=nums2.length;j++) {
                mem[i][j][0] = Integer.MIN_VALUE;
                mem[i][j][1] = Integer.MIN_VALUE;
            }
        }
        return getMax(nums1,nums2,nums1.length,nums2.length, 1, mem);
    }
}