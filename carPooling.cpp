/* You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. */

class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        map<int,int> times;
        for(int i = 0;i<trips.size();i++) {
            
            times[trips[i][1]]+=trips[i][0];
            times[trips[i][2]]-=trips[i][0];
            
        }
        bool isPossible = true;
        int currCap = 0;
        for(auto i : times) {
            currCap+=i.second;
            if(currCap>capacity) {
                isPossible = false;
                break;
            }
        }
        return isPossible;
    }
};