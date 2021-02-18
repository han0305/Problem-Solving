/* You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number. */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        for(int i=0;i<nums2.length;i++) {
            
            while(!st.isEmpty() && nums2[i] > st.peek()) {
                int key = st.pop();
                hm.put(key,nums2[i]);
            }
            st.push(nums2[i]);
        }
        // while(!st.isEmpty()) {
        //     int key = st.pop();
        //     hm.put(key,-1);
        // }
        
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            res[i] = hm.getOrDefault(nums1[i],-1);
        }
        
        return res;
    }
}