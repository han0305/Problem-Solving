/* Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list. */


class Solution {
public:
    int getMin(string s1) {
        
        int hr = stoi(s1.substr(0,2));
        int min = stoi(s1.substr(3,2));
        int minutes = hr*60 + min;
        return minutes;
    }
    int findMinDifference(vector<string>& timePoints) {
        
        int l = timePoints.size();
        if(l>24*60) {
            return 0;
        }
        vector<int> times;
        for(int i=0;i<l;i++) {
            int minutes = getMin(timePoints[i]);
            times.push_back(minutes);
        }
        sort(times.begin(),times.end());
        times.push_back(times[0]+24*60);
        int minm = INT_MAX;
        for(int i = 1;i<times.size();i++) {
            minm = min(minm,times[i]-times[i-1]);
        }
        return minm;
    }
};