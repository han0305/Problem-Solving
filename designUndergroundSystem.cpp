class UndergroundSystem {
public:
     unordered_map<int,pair<string,int>> checkInMap;
    unordered_map<string,pair<double,int>> avg;
    UndergroundSystem() {
        
    }
    
    void checkIn(int id, string stationName, int t) {
          checkInMap[id] = make_pair(stationName,t);
    }
    
    void checkOut(int id, string stationName, int t) {
         pair<string,int> checkInTime = checkInMap[id];
        string key = checkInTime.first + " " + stationName;
        if(avg.find(key) == avg.end()) {
            avg[key] = make_pair(t-checkInTime.second,1);
        }
        else {
            int total = t-checkInTime.second;
            double avgTime = (double)(avg[key].first*avg[key].second + total)/(avg[key].second+1);
            avg[key] = make_pair(avgTime,avg[key].second+1);
        }
    }
    
    double getAverageTime(string startStation, string endStation) {
         return avg[startStation + " " + endStation].first;
    }
};

