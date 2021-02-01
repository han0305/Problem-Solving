/* Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array. */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashSet<Integer> hm = new HashSet<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(hm.contains(nums[i]))
                res.add(nums[i]);
            else
                hm.add(nums[i]);
        }
        
        return res;
    }
}


