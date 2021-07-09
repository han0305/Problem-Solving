/* Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward. */

class Solution {
    private int getMinInsertions(String s, int idx1, int idx2,int[][] mem) {
        if(idx1>=idx2) {
            return 0;
        }
        if(mem[idx1][idx2]!=-1) {
            return mem[idx1][idx2];
        }
        if(s.charAt(idx1) == s.charAt(idx2)) {
            mem[idx1][idx2] = getMinInsertions(s,idx1+1,idx2-1,mem);
            return mem[idx1][idx2];
        }
        
        mem[idx1][idx2] = 1+Math.min(getMinInsertions(s,idx1+1,idx2,mem),getMinInsertions(s,idx1,idx2-1,mem));
        return mem[idx1][idx2];
    }
    public int minInsertions(String s) {
        int[][] mem = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<s.length();j++) {
                mem[i][j] = -1;
            }
        }
        return getMinInsertions(s,0,s.length()-1,mem);
    }
}