/*Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.*/

class Solution {
public:
    vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
        int am = A.size();
        int bm = B.size();
        int an = A[0].size();
        int bn = B[0].size();
        
        unordered_map<int,vector<int>> amap;
        unordered_map<int,vector<int>> bmap;
        
        for(int i=0;i<am;i++) {
            for(int j=0;j<an;j++) {
                
                if(A[i][j]) {
                    amap[i].push_back(j);
                }
            }
        }
        
        for(int i=0;i<bm;i++) {
            for(int j=0;j<bn;j++) {
                
                if(B[i][j]) {
                    bmap[j].push_back(i);
                }
            }
        }
        
        vector<vector<int>> res(am,vector<int>(bn,0));
        for(int i=0;i<am;i++) {
            for(int j=0;j<bn;j++) {
                vector<int> a = amap[i];
                vector<int> b = bmap[j];
                int ai = 0;
                int bi = 0;
                int n1 = a.size();
                int n2 = b.size();
                int mul = 0;
                while(ai<n1 && bi<n2) {
                    if(a[ai] == b[bi]) {
                        mul+=A[i][a[ai]] * B[b[bi]][j];
                        ai++;
                        bi++;
                    }
                    else if(a[ai]>b[bi]) {
                        bi++;
                    }
                    else ai++;
                }
                res[i][j] = mul;
                
            }
            
        }
        
        return res;
    }
};