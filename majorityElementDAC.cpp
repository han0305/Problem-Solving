/* Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array. */

class Solution {
public:
    
    int getCount(vector<int> nums,int start,int end,int ele) {
        
        int count = 0;
        for(int i=start;i<=end;i++) {
            if(nums[i] == ele)
                count++;
        }
        
        return count;
    }
    
    
    int getMajorityElement(vector<int> nums,int start,int end) {
        
        if(start == end) {
            return nums[start];
        }
        int mid = (start+end)/2;
        
        int leftEle = getMajorityElement(nums,start,mid);
        int rightEle = getMajorityElement(nums,mid+1,end);
        
        if(leftEle == rightEle)
            return leftEle;
        
        int leftEleCount = getCount(nums,start,end,leftEle);
        int rightEleCount = getCount(nums,start,end,rightEle);
        
        return leftEleCount>rightEleCount?leftEle:rightEle;
        
        
    }
    
    int majorityElement(vector<int>& nums) {
        return getMajorityElement(nums,0,nums.size()-1);
    }
};