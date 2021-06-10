/* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character */

class Solution {
    private int getMin(String word1, String word2,int idx1,int idx2, int[][] mem) {
        if(mem[idx1][idx2]!=-1){
            return mem[idx1][idx2];
        }
        if(idx1==0||idx2==0) {
            mem[idx1][idx2] = idx1==0?idx2:idx1;
            return mem[idx1][idx2];
        }
        if(word1.charAt(idx1-1)==word2.charAt(idx2-1)) {
            mem[idx1][idx2] = getMin(word1,word2,idx1-1,idx2-1,mem);
            return mem[idx1][idx2];
        }
        
        mem[idx1][idx2] = 1+Math.min(getMin(word1,word2,idx1,idx2-1,mem),Math.min(getMin(word1,word2,idx1-1,idx2,mem),getMin(word1,word2,idx1-1,idx2-1,mem)));
        return mem[idx1][idx2];
    }
    public int minDistance(String word1, String word2) {
        
        int[][] mem = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<mem.length;i++) {
            for(int j=0;j<mem[i].length;j++) {
                mem[i][j] = -1;
            }
        }
        return getMin(word1,word2,word1.length(),word2.length(),mem);
    }
}