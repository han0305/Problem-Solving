/* A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city. */

bool compFunc(vector<int> v1,vector<int> v2) {
    
    return (v1[0]-v1[1]) < (v2[0]-v2[1]);
}


class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        sort(costs.begin(),costs.end(),compFunc);
        int n = costs.size();
        n = n/2;
        int total = 0;
        for(int i=0;i<n;i++) {
            total = total + costs[i][0] + costs[i+n][1];
        }
        
        return total;
        
    }
};