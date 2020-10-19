/* In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1. */

class Solution {
public:
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        
        vector<int> ACount(6,0);
        vector<int> BCount(6,0);
        vector<int> ABCount(6,0);
        int l = A.size();
        
        for(int i=0;i<l;i++) {
            if(A[i] == B[i]) {
                ABCount[A[i]-1]++;
            }
            else  {
                ACount[A[i]-1]++;
                BCount[B[i]-1]++;
            }
        }
        int count = INT_MAX;
        for(int i = 0;i<6;i++) {
            if(l - (ACount[i] + ABCount[i]) == BCount[i]) {
                count = min(count,BCount[i]);
            }
            if(l - (BCount[i] + ABCount[i]) == ACount[i]) {
                count = min(count,ACount[i]);
            }
        }
        
        return count == INT_MAX?-1:count;
    }
};