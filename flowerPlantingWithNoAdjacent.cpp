/* You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.

All gardens have at most 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists. */

class Solution {
public:
    bool backtrack(vector<vector<int>>& graph,int src,vector<int>& type) {
        int flowers[] = {1,2,3,4};
        vector<int> neighbors = graph[src];
        for(int i=0;i<4;i++) {
            type[src] = flowers[i];
            int j =0;
            while(j<neighbors.size()) {
                if(type[neighbors[j]] != 0) { 
                    if(type[neighbors[j]]  == type[src])
                        break;
                }
                else if(!backtrack(graph,neighbors[j],type)) 
                    break;
                j++;
            }
            
            if(j == neighbors.size())
                return true;
            
        }
        
        return false;
    }
    
    
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        vector<vector<int>> graph(n);
        for(int i=0;i<paths.size();i++) {
            
            graph[paths[i][0]-1].push_back(paths[i][1]-1);
            graph[paths[i][1]-1].push_back(paths[i][0]-1);
            
        }
        vector<int> res(n,0);
        for(int i=0;i<n;i++) {
            
            if(res[i] == 0) {
                backtrack(graph,i,res);
            }
            //cout<<res[i]<<endl;
        }
        
        
        return res;
    }
};