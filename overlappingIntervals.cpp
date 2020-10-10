/* Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping. */

bool compareFunc(vector<int> a,vector<int> b) {
    
    return a[0]<b[0];
}


class Solution {
public:
    
    bool isOverlapping(vector<vector<int>>& intervals,int prev,int curr) {
        
        return intervals[prev][1]>intervals[curr][0];
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        int count = 0;
        sort(intervals.begin(),intervals.end(),compareFunc);
        int prev = 0;
        
        for(int i=1;i<n;i++) {
            
            if(isOverlapping(intervals,prev,i)) {
                
                if(intervals[prev][1]>intervals[i][1]) {
                    prev = i;
                }
                count++;
            }
            else {
                prev = i;
            }
            
        }
        
        return count;
    }
};
