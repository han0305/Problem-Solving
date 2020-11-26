/* There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure. */

class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        unordered_map<int,int> umap;
        vector<vector<int>> connection(n,vector<int>(n,0));
        int l = roads.size();
        for(int i=0;i<l;i++) {
            umap[roads[i][0]]++;
            umap[roads[i][1]]++;
            connection[roads[i][0]][roads[i][1]] =1;
            connection[roads[i][1]][roads[i][0]] =1;
        }
        int maxm = 0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                //cout<<i<<" "<<j<<endl;
                
                int currMax = umap[i]+umap[j];
               // cout<<currMax<<endl;
                if(connection[i][j]==1) 
                    currMax-=1;
                 maxm = max(maxm,currMax);
                
            }
        }
        return maxm;
    }
};