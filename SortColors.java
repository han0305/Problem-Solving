/* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively. */

class Solution {
    private void swap(int[] nums,int idx1,int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void sortColors(int[] nums) {
        int start = -1;
        int end = nums.length;
        int i=0;
        while(i<end) {
            if(nums[i] == 0) {
                start++;
                swap(nums,start,i);
                i++;
            }
            else if(nums[i] == 2) {
                end--;
                swap(nums,end,i);
            }
            else 
                i++;
        }
        
    }
}