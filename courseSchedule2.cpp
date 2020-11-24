/* There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array. */

class Solution {
public:
    
    bool dfs(int i,vector<vector<int>> g,vector<bool> &visited,vector<bool> &inProcess, vector<int> &res) {
        
        if(inProcess[i] == true) {
            return true;
        }
        visited[i] = true;
        inProcess[i] = true;
        bool deadlock = false;
        for(int j = 0;j<g[i].size();j++) {
            if(inProcess[g[i][j]]){
                return true;
            }
            
            if(visited[g[i][j]] == false) {
                deadlock = dfs(g[i][j],g,visited,inProcess,res);
            }
            if(deadlock == true) {
                return true;
            }
        }
        inProcess[i] = false;
        res.push_back(i);
        return deadlock;
        
        
    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> g(numCourses);
        
        for(int i=0;i<prerequisites.size();i++) {
            g[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        vector<int> res;
        vector<bool> visited(numCourses,false);
        bool deadlock = false;
        
        for(int i=0;i<numCourses;i++) {
            vector<bool> inProcess(numCourses,false);
            if(visited[i] == false) {
               deadlock =  dfs(i,g,visited,inProcess,res);
            }
            if(deadlock == true) {
                res = {};
                break;
            }
        }
        
        return res;
        
        
    }
};