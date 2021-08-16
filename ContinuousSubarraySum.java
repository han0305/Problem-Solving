/* Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k. */

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 1) {
            return false;
        }
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            int mod = sum%k;
            if(hm.containsKey(mod)) {
                int idx = hm.get(mod);
                if(i-idx>1) {
                    return true;
                }
            }
            else {
                hm.put(mod,i);
            }
        }
        
        return false;
    }
}