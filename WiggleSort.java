/* Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3].... */

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <=2)
            return;
        for(int i=2;i<nums.length;i=i+2) {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
            
        }
    }
}