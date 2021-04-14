/* Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1). */

class Solution {
    public int maxProduct(int[] nums) {
        
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            
            if(nums[i]>=firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i]>secondMax) {
                secondMax = nums[i];
            }
        }
        
        return (firstMax-1) * (secondMax-1);
    }
}