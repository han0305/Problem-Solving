/* Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division. */

class Solution {
public:
    vector<vector<int>> highFive(vector<vector<int>>& items) {
        
        map<int,vector<int>> marks;
        int l = items.size();
        for(int i =0;i<l;i++) {
            
            marks[items[i][0]].push_back(items[i][1]);
        }
        vector<vector<int>> res(marks.size());
        int ind = 0;
        for(auto i:marks) {
            
            vector<int> marksArray = i.second;
            sort(marksArray.begin(),marksArray.end(),greater<int>());
            int sum = 0;
            for(int j=0;j<5;j++) {
                sum+=marksArray[j];
            }
            int avg = sum/5;
            res[ind].push_back(i.first);
            res[ind++].push_back(avg);
        }
        return res;
    }
};