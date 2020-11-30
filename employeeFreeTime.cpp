/* We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length. */

class Compare
{
public:
    bool operator() (Interval i1, Interval i2)
    {
        return i1.start>i2.start;
    }
};
class Solution {
public:
    vector<Interval> employeeFreeTime(vector<vector<Interval>> schedule) {
        
        vector<Interval> res;
        priority_queue<Interval,vector<Interval>,Compare> pq;
        for(int i = 0;i<schedule.size();i++) {
            for(int j=0;j<schedule[i].size();j++)
              pq.push(schedule[i][j]);
        }
        int currEnd = INT_MAX;
        while(!pq.empty()) {
            
            Interval next = pq.top();
            pq.pop();
            if(currEnd<next.start) {
                Interval freeTime;
                freeTime.start = currEnd;
                freeTime.end = next.start;
                res.push_back(freeTime);
            }
            if(currEnd == INT_MAX)
                currEnd = next.end;
            //cout<<currEnd<<endl;
            currEnd = max(currEnd,next.end);
        }
        
        
        
        return res;
        
    }
};