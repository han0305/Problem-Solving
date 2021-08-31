/* You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y. */

class Pair {
    
    int ones = 0;
    int zeros = 0;
    Pair(int ones, int zeros) {
        this.ones = ones;
        this.zeros = zeros;
    }
}
class Solution {
    private int getLargestSubset(Pair[] counts, int idx, int m, int n, int len, int[][][] mem) {
        
        if(idx == len || (m==0 &&  n==0)) {
            return 0;
        }
        if(mem[idx][m][n]!=-1) {
            return mem[idx][m][n];
        }
        if(counts[idx].zeros>m || counts[idx].ones>n) {
            return mem[idx][m][n] = getLargestSubset(counts,idx+1,m,n,len,mem);
        }
        
        return mem[idx][m][n] = Math.max(1+getLargestSubset(counts,idx+1,m-counts[idx].zeros,n-counts[idx].ones,len,mem), getLargestSubset(counts,idx+1,m,n,len,mem));
        
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Pair[] counts = new Pair[len];
        int[][][] mem = new int[len][m+1][n+1];
        for(int i=0;i<len;i++) {
            for(int j=0;j<=m;j++) {
                for(int k=0;k<=n;k++) {
                    mem[i][j][k] = -1;
                }
            }
        }
        for(int i=0;i<len;i++) {
            int ones = 0, zeros = 0;
            for(int j=0;j<strs[i].length();j++) {
                if(strs[i].charAt(j) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            
            counts[i] = new Pair(ones,zeros);
        }
        
        return getLargestSubset(counts,0,m,n,len,mem);
        
        
    }
}