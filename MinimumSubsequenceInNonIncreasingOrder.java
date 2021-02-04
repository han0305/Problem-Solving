/* Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence. 

If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 

Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order. */

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }
        List<Integer> res = new ArrayList<Integer>();
        int currSum = 0;
        for(int i=nums.length-1;i>=0;i--) {
            res.add(nums[i]);
            sum-=nums[i];
            currSum+=nums[i];
            if(currSum>sum)
                break;
        }
        return res;
    }
}