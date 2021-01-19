/* Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs. */

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            int currCount = hm.getOrDefault(nums[i],0);
            count+=currCount;
            hm.put(nums[i],currCount+1);
        }
        
        return count;
    }
}