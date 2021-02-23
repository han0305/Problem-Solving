/* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++) {
            
            int start = i+1;
            int end = nums.length-1;
            if(i>0 && nums[i] == nums[i-1])
                continue;
            while(start<end) {
                if(start>i+1 && nums[start] == nums[start-1]){
                    start++;
                    continue;
                }
                if(end<nums.length-1 && nums[end] == nums[end+1]){
                    end--;
                    continue;
                }
                int sum = nums[i] + nums[start] + nums[end];
                if(sum==0) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[start]);
                    curr.add(nums[end]);
                    res.add(curr);
                    start++;
                    end--;
                }
                else if(sum>0)
                    end--;
                else 
                    start++;
                
            }
            
            
        }
        return res;
     }
}