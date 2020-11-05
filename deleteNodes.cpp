/* A tree rooted at node 0 is given as follows:

The number of nodes is nodes;
The value of the i-th node is value[i];
The parent of the i-th node is parent[i].
Remove every subtree whose sum of values of nodes is zero.

After doing so, return the number of nodes remaining in the tree. */

class Solution {
public:
    
    pair<int,int> dfs( unordered_map<int,vector<int>>& graph,vector<int>& value,int root) {
        
        int count = 1;
        int sum = value[root];
        vector<int> children = graph[root];
        int l = children.size();
        for(int i=0;i<l;i++) {
            
            pair<int,int> res = dfs(graph,value,children[i]);
            sum+=res.first;
            count+=res.second;
        }
        
        if(sum == 0) {
            return make_pair(0,0);
        }
        else {
            return make_pair(sum,count);
        }
    }
    int deleteTreeNodes(int nodes, vector<int>& parent, vector<int>& value) {
        
        unordered_map<int,vector<int>> graph;
        int l = parent.size();
        for(int i=1;i<l;i++) {
            
            graph[parent[i]].push_back(i);
        }
        
        return dfs(graph,value,0).second;
        
    }
};