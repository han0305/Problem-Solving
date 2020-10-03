/* Leetcode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.

You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.

Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".

Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.

Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "23:51" - "00:10" is not considered to be within a one-hour period. */


bool compareFunc(pair<int,int> p_1, pair<int,int> p_2) 
{ 
    if(p_1.first<p_2.first) {
        return true;
    }
    else if(p_1.first>p_2.first) {
        return false;
    }
    else {
        if(p_1.second<p_2.second) {
            return true;
        }
        else {
            return false;
        }
    }
} 

class Solution {
public:
     bool isWithinHr(pair<int,int> prev,pair<int,int> curr) {
        
       
        int prevHr = prev.first;
        int prevMin = prev.second;
        int currHr = curr.first;
        int currMin = curr.second;
        
        if(prevHr == currHr) {
            return true;
        }
        else if((abs(currHr - prevHr) == 1)  && currMin <= prevMin) {
            
                return true;
            
        }
        
        return false;
    }
    pair<int,int> getTimes(string time) {

        int currHr = stoi(time.substr(0,2));
        int currMin = stoi(time.substr(3,2));
        
        return make_pair(currHr,currMin);
        
    }
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        
        int l  =keyName.size();
        unordered_map<string,vector<pair<int,int>>> hist;
        vector<string> res;
        for(int i=0;i<l;i++) {
            
            hist[keyName[i]].push_back(getTimes(keyTime[i]));
            
        }
        
        for(auto i:hist) {
            
            vector<pair<int,int>> times = i.second;
            int count = 1;
            sort(times.begin(),times.end(),compareFunc);
            int len = times.size();
            if(len == 0) 
                continue;
            int j = 0;
            int minHr = times[0].first;
            int minMin = times[0].second;
            for(int i=1;i<len;i++) {
                if(isWithinHr(make_pair(minHr,minMin),times[i])) {
                    count++;
                    if(count == 3)
                        break;
                }
                else {
                    while(j<i && !isWithinHr(times[j],times[i])) {
                        j++;
                    }
                    minHr = times[j].first;
                    minMin = times[j].second;
                    count = i-j+1;
                }
            }

            if(count == 3) {
                res.push_back(i.first);
            }
            
        } 
        
        sort(res.begin(),res.end());
        return res;
        
    }
};