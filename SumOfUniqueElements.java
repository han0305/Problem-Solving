/* You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums. */

class Solution {
    public int sumOfUnique(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            int currFreq = hm.getOrDefault(nums[i],0);
            if(currFreq == 0) {
                sum+=nums[i];
            }
            else if(currFreq == 1) {
                sum-=nums[i];
            }
            currFreq++;
            hm.put(nums[i],currFreq);
            
        }
        
        return sum;
    }
}