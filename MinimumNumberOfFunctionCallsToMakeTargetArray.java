/*
func modify(arr,op,idx) {

    if(op==0) {
        arr[idx] = arr[idx]+1;
    }
    if(op==1) {
        for(i=0;i<arr.length;i++) {
            arr[i] = arr[i] * 2;
        }
    }
}
 Your task is to form an integer array nums from an initial array of zeros arr that is the same size as nums.

Return the minimum number of function calls to make nums from arr.

The answer is guaranteed to fit in a 32-bit signed integer. */

class Solution {
    public int minOperations(int[] nums) {
        int inc = 0;
        int mul = 0;
        for(int i=0;i<nums.length;i++) {
            
            int no = nums[i];
            int currMul = 0;
            while(no>0) {
                if(no%2==0) {
                    no=no/2;
                    currMul++;
                }
                else {
                    no--;
                    inc++;
                }
            }
            mul = Math.max(mul,currMul);
        }
        
        return inc+mul;
    }
}

