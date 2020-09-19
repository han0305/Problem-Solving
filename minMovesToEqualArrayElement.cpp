/* Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1. */

class Solution {
public:
    int minMoves(vector<int>& nums) {
        int moves = 0, minm = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            minm = min(minm, nums[i]);
        }
        for (int i = 0; i < nums.size(); i++) {
            moves += nums[i] - minm;
        }
        return moves;
    
    }
};