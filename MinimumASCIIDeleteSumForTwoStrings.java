/* Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal. */

class Solution {
    int minDeletionCost(String s1,String s2,int idx1,int idx2,int[][] mem) {
        if(mem[idx1][idx2]!=-1) {
            return mem[idx1][idx2];
        }
        if(idx1==0 && idx2==0 ) {
            mem[idx1][idx2]=0;
            return mem[idx1][idx2];
        }
        if(idx1==0) {
            mem[idx1][idx2] = 0;
            int idx = idx2;
            while(idx>0) {
                mem[idx1][idx2]+=(s2.charAt(idx-1));
                idx--;
            }
            return mem[idx1][idx2];
        }
        if(idx2==0) {
           mem[idx1][idx2]=0;
           int idx = idx1;
           while(idx>0) {
                mem[idx1][idx2]+=(s1.charAt(idx-1));
                idx--;
            }
            return mem[idx1][idx2]; 
        }
        if(s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
            mem[idx1][idx2]=minDeletionCost(s1,s2,idx1-1,idx2-1,mem);
            return  mem[idx1][idx2];
        }
        int cost1 = (s1.charAt(idx1-1))+minDeletionCost(s1,s2,idx1-1,idx2,mem);
        int cost2 = (s2.charAt(idx2-1))+minDeletionCost(s1,s2,idx1,idx2-1,mem);
        mem[idx1][idx2]=Math.min(cost1,cost2);
        return mem[idx1][idx2];
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] mem = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<mem.length;i++) {
            for(int j=0;j<mem[i].length;j++) {
                mem[i][j] = -1;
            }
        }
        return minDeletionCost(s1,s2,s1.length(),s2.length(),mem);
        
    }
}