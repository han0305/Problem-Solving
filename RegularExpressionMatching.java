/* Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

*/

class Solution {
    private boolean isMatchUtil(String s, String p, int idx1, int idx2) {
        
        if(idx1==0 && idx2==0) {
            return true;
        }
        if(idx2==0) {
            return false;
        }
        if(idx1==0) {
            int j = idx2;
            while(j>0 && p.charAt(j-1)=='*') {
                j=j-2;
            }
            return j==0;
        }
        
        if(s.charAt(idx1-1) == p.charAt(idx2-1) || p.charAt(idx2-1) == '.' ) {
            return isMatchUtil(s,p,idx1-1,idx2-1);
        }
        if(p.charAt(idx2-1) == '*') {
            if(s.charAt(idx1-1) == p.charAt(idx2-2) || p.charAt(idx2-2) == '.') {
                return isMatchUtil(s,p,idx1-1,idx2) || isMatchUtil(s,p,idx1,idx2-2);
            }
            else {
                return isMatchUtil(s,p,idx1,idx2-2);
            }
        }
        
        return false;
    }
    public boolean isMatch(String s, String p) {
        
        return isMatchUtil(s,p,s.length(),p.length());
    }
}