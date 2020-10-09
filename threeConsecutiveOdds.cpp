/* Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false. */

class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        
        int n = arr.size();
        int count = 0;
        
        for(int i=0;i<n;i++) {
            
            if(arr[i]%2!=0) {
                count++;
            }
            else 
                count=0;
            if(count == 3)
                return true;
            
        }
         return false;
    }
};