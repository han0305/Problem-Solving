/* Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i < seq.length - 1). */

class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;    
        ArrayList<HashMap<Integer,Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new HashMap<>());
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            int currMax = 1;
            for(int j=i-1;j>=0;j--) {
                
                int curr = 1 + list.get(j).getOrDefault(nums[i]-nums[j],1);
                int currExist = list.get(i).getOrDefault(nums[i]-nums[j],0);
                list.get(i).put(nums[i]-nums[j],Math.max(curr,currExist));
                currMax  = Math.max(currMax,curr);
                
            }
            
            res = Math.max(res,currMax);
        }
        
        return res;
    }
}