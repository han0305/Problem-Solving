/* You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false. */

class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int,pair<int,int>> locMap;
        unordered_map<int,int> colMap; 
        for(int i=0;i<pieces.size();i++) {
            for(int j=0;j<pieces[i].size();j++) {
                locMap[pieces[i][j]] = {i,j};
            }
            colMap[i] = -1;
        
        }
        
        bool isPossible = true;
        int prevRow = -1;
        for(int i=0;i<arr.size();i++) {
            if(locMap.find(arr[i])!=locMap.end()) {
                int row = locMap[arr[i]].first;
                int col = locMap[arr[i]].second;
                if(prevRow!=-1 && prevRow!=row) {
                    if(pieces[prevRow].size()-1!=colMap[prevRow]) {
                        isPossible = false;
                        break;
                    }
                }
                prevRow = row;
                if(col < colMap[row]) {
                    isPossible = false;
                    break;
                }
                colMap[row] = col;    
            }
            else {
                isPossible = false;
                break;
            }
            
        }
        
        return isPossible;
    }
};