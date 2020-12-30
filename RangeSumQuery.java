/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j])) */

class NumArray {
    int[] sum;
    int[] num;
    public NumArray(int[] nums) {
        int l = nums.length;
        num = nums;
        sum = new int[l];
        int currSum = 0;
        for(int i=0;i<l;i++) {
            sum[i] = nums[i]+currSum;
            currSum+=nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return (sum[j]-sum[i]) + num[i];
        
    }
}