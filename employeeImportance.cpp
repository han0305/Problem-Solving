/* You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates. */

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    void dfs(int id, unordered_map<int,pair<int,vector<int>>> graph,int& totalImp, unordered_map<int,int>& visited) {
        
        visited[id] = 1;
        totalImp+=graph[id].first;
        vector<int> subs = graph[id].second;
        int l = subs.size();
        
        for(int i=0;i<l;i++) {
            
            if(visited.find(subs[i]) == visited.end()) {
                dfs(subs[i],graph,totalImp,visited);
            }
        }
        
    }
    
    
    int getImportance(vector<Employee*> employees, int id) {
        
        unordered_map<int,pair<int,vector<int>>> graph;
        int l = employees.size();
        
        for(int i=0;i<l;i++) {
            graph[employees[i]->id] = make_pair(employees[i]->importance,employees[i]->subordinates);
        }
        
        int totalImp = 0;
        unordered_map<int,int> visited;
        dfs(id,graph,totalImp,visited);
        return totalImp;
    }
};