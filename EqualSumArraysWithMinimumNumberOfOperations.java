/* You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.

In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.

Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2. Return -1​​​​​ if it is not possible to make the sum of the two arrays equal. */

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0;
        for(int i = 0;i<nums1.length;i++)
            sum1+=nums1[i];
        int sum2 = 0;
        for(int i = 0;i<nums2.length;i++)
            sum2+=nums2[i];
        if(sum1==sum2)
            return 0;
        if(sum1<sum2) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int diff = Math.abs(sum1-sum2);
        
        int i=nums1.length-1;
        int j=0;
        
        int count=0;
        while((i>=0 || j<nums2.length) && diff>0) {
            if(i>=0 && (j==nums2.length || nums1[i]-1>6-nums2[j])) {
                for(int no=1;no<nums1[i];no++) {
                    if(nums1[i]-no<=diff) {
                        diff-=(nums1[i]-no);
                        count++;
                        break;
                    }
                }
                i--;
            }
            else if(j<nums2.length) {
                for(int no=6;no>nums2[j];no--) {
                    if(no-nums2[j]<=diff) {
                        diff-=(no-nums2[j]);
                        count++;
                        break;
                    }
                }
                j++;
            }
              
        }
        
        return diff == 0 ? count:-1;
    }
}