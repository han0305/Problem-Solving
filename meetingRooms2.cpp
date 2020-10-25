/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required. */

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        if(intervals.size() == 0) {
            return 0;
        }
        map<int,int> times;
        for(int i = 0;i<intervals.size();i++) {
            
            times[intervals[i][0]]++;
            times[intervals[i][1]]--;
            
        }
        int res = INT_MIN;
        int currCap = 0;
        for(auto i : times) {
            currCap+=i.second;
            res = max(res,currCap);
        }
        return res;
    }
    
};