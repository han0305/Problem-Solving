/* Given an integer array arr, return the mean of the remaining integers after removing the smallest 5% and the largest 5% of the elements.

Answers within 10-5 of the actual answer will be considered accepted. */

class Solution {
public:
    double trimMean(vector<int>& arr) {
        
        int l = arr.size();
        double remove = 0.05 * l;
        sort(arr.begin(),arr.end());
        int start = 0;
        while(start<remove) {
            start++;
        }
        double sum = 0;
        double count = 0;
       // cout<<start<<" "<<l - remove;
        for(int i=start;i<l-remove;i++) {
            sum = sum+arr[i];
            count++;
        }
        return sum/count;
        
        
    }
};