/* Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. */

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                int j = 0;
                while (nums[i] > res.get(j)) {
                    j++;
                }
                
                res.set(j, nums[i]);
            }
        }
        
        return res.size();
    }
}