/* Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing. */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        len[0] = 1;
        count[0] = 1;
        int maxm = 1;
        for(int i=1;i<n;i++) {
             int maxLen = 1;
             len[i]=1;
             count[i]=1;
            for(int j=0;j<i;j++) {
               
                if(nums[i]>nums[j]) {
                    int currLen  = 1+len[j];
                    if(currLen==maxLen) {
                        count[i]+=count[j];
                    }
                    else if(currLen>maxLen) {
                        count[i] = count[j];
                        maxLen = currLen;
                    }
                    len[i]=maxLen;
                }
                
            }
            maxm = Math.max(maxm,len[i]);
        }
        int totalCount = 0;
        for(int i=0;i<n;i++) {
            if(len[i] == maxm) {
                totalCount+=count[i];
            }
        }
        return totalCount;
    }
}