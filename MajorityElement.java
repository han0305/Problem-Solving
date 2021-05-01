/* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array. */

class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int res = -1;
        
        for(int i=0;i<nums.length;i++) {
            
            int freq = hm.getOrDefault(nums[i],0);
            freq++;
            
            if(freq>Math.ceil(nums.length/2)) {
                
                res = nums[i];
                break;
            }
            
            hm.put(nums[i],freq);
        }
        
        return res;
    }
}