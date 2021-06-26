/* Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays. */

class Solution {
    
    int getMaxUtil(int[] nums1, int[] nums2, int idx1, int idx2, int[][] mem) {
        
        if(idx1 >= nums1.length || idx2 >= nums2.length) {
            return 0;
        }
        if(mem[idx1][idx2]!=-1)
            return mem[idx1][idx2];
        int currMax = 0;
        int i = idx1;
        int j = idx2;
        while(i<nums1.length && j<nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
            currMax++;
        }
        
        mem[idx1][idx2] = Math.max(currMax,Math.max(getMaxUtil(nums1,nums2,idx1,idx2+1,mem),getMaxUtil(nums1,nums2,idx1+1,idx2,mem)));
        return mem[idx1][idx2];
    }
    public int findLength(int[] nums1, int[] nums2) {
        int[][] mem = new int[nums1.length][nums2.length];
        for(int i=0;i<mem.length;i++) {
            for(int j=0;j<mem[i].length;j++) {
                mem[i][j] = -1;
            }
        }
        return getMaxUtil(nums1,nums2,0,0,mem);
    }
}