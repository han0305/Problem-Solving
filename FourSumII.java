/* Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums[l] == 0 */

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                int sum = nums1[i]+nums2[j];
                int freq = hm.getOrDefault(sum,0)+1;
                hm.put(sum,freq);
            }
        }
        
        int count = 0;
        for(int i=0;i<nums3.length;i++) {
            for(int j=0;j<nums4.length;j++) {
                int sum = nums3[i]+nums4[j];
                count+=hm.getOrDefault(-1*sum,0);
            }
        }
        
        return count;
    }
}