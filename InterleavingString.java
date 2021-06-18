/* Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b. */

class Solution {
    boolean isInterleaveUtil(String s1, String s2, String s3, int idx1, int idx2, int idx3, int[][] mem) {
        if(idx1 == 0 && idx2 == 0 && idx3 == 0) {
            mem[idx1][idx2] = 1;
        }
        else if(idx3 == 0) {
            mem[idx1][idx2] = 0;
        } 
        else if(idx1 == 0) {
            mem[idx1][idx2]  = s2.substring(0,idx2).equals(s3.substring(0,idx3)) == true ? 1 : 0;
        }
        else if(idx2 == 0) {
            mem[idx1][idx2] =s1.substring(0,idx1).equals(s3.substring(0,idx3)) == true ? 1 : 0;
        }
        if(mem[idx1][idx2]!=-1) {
            return mem[idx1][idx2] == 1;
        }
        
        if((s1.charAt(idx1-1) ==  s3.charAt(idx3-1)) && (s2.charAt(idx2-1) == s3.charAt(idx3-1)) ) {
            mem[idx1][idx2]=(isInterleaveUtil(s1,s2,s3,idx1-1,idx2,idx3-1,mem) || isInterleaveUtil(s1,s2,s3,idx1,idx2-1,idx3-1,mem)) == true ? 1:0;
            return mem[idx1][idx2] == 1;
        }
        if(s1.charAt(idx1-1) == s3.charAt(idx3-1)) {
            mem[idx1][idx2]=isInterleaveUtil(s1,s2,s3,idx1-1,idx2,idx3-1,mem) == true?1:0;
            return mem[idx1][idx2] == 1;
        }
        if(s2.charAt(idx2-1) == s3.charAt(idx3-1)) {
            mem[idx1][idx2] = isInterleaveUtil(s1,s2,s3,idx1,idx2-1,idx3-1,mem) == true ? 1:0;
            return mem[idx1][idx2] == 1;
        }
        mem[idx1][idx2] = 0;
        return false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] mem = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<mem.length;i++) {
            for(int j=0;j<mem[i].length;j++) {
                mem[i][j] = -1;
            }
        }
        return isInterleaveUtil(s1,s2,s3,s1.length(),s2.length(),s3.length(),mem);
    }
}