/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial). */

class Solution {
    private boolean isMatchUtil(String s, String p, int idx1, int idx2, int[][] mem) {
        
        if(idx1 == 0 && idx2 == 0) {
            return true;
        }
        if(idx2 == 0) {
            return false;
        }
        if(idx1 == 0) {
            while(idx2>0 && p.charAt(idx2-1) == '*') {
                idx2--;
            }
            return idx2==0;
        }
        if(mem[idx1][idx2]!=-1) {
            return mem[idx1][idx2] == 1? true:false;
        }
        if(s.charAt(idx1-1) == p.charAt(idx2-1) || p.charAt(idx2-1) == '?') {
            mem[idx1][idx2] =  isMatchUtil(s,p,idx1-1,idx2-1,mem) == true?1:0;
            return mem[idx1][idx2] == 1?true:false;
        }
        if(p.charAt(idx2-1) == '*') {
            boolean res = isMatchUtil(s,p,idx1-1,idx2,mem) || isMatchUtil(s,p,idx1-1,idx2-1,mem) || isMatchUtil(s,p,idx1,idx2-1,mem);
            mem[idx1][idx2] = res == true?1:0;
            return res;
        }
        
        mem[idx1][idx2] = 0;
        return false;
    }
    public boolean isMatch(String s, String p) {
        int[][] mem = new int[s.length()+1][p.length()+1];
        for(int i=0;i<=s.length();i++) {
            for(int j=0;j<=p.length();j++) {
                mem[i][j] = -1;
            }
        }
        return isMatchUtil(s,p,s.length(),p.length(),mem);
    }
}