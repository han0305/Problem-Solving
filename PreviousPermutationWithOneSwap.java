/* Given an array of positive integers arr (not necessarily distinct), return the lexicographically largest permutation that is smaller than arr, that can be made with exactly one swap (A swap exchanges the positions of two numbers arr[i] and arr[j]). If it cannot be done, then return the same array. */

class Solution {
    
    private void swap(int[] arr,int idx1,int idx2) {
        
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    public int[] prevPermOpt1(int[] arr) {
        
        int prevFirstIdx = -1;
        int prevSecondIdx = -1;
        int firstIdx = 0;
        int secondIdx = -1;
        
        for(int i=1;i<arr.length;i++) {

                
            if(arr[i] >= arr[firstIdx]) {
                if(secondIdx!=-1) {
                prevFirstIdx = firstIdx;
                prevSecondIdx = secondIdx;
                }
                firstIdx = i;
                secondIdx = -1;
            }
            else if(secondIdx!=-1 && arr[i]>arr[secondIdx]) {
                secondIdx = i;
            }
            else if(secondIdx!=-1 && arr[i] < arr[secondIdx]) {
                
                firstIdx = secondIdx;
                secondIdx = i;
                
            }
            else if(secondIdx == -1){
                secondIdx = i;
            }
            
            
        }
        
        if(firstIdx!=-1 && secondIdx!=-1) {
            swap(arr,firstIdx,secondIdx);
        }
        else if(prevFirstIdx!=-1 && prevSecondIdx!=-1) {
            swap(arr,prevFirstIdx,prevSecondIdx);
        }
        
        return arr;
    }
}