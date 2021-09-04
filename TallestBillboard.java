/* You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.

You are given a collection of rods that can be welded together. For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.

Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0. */

class Solution {
    private int getMaxHeight(int[] rods, int idx, int sum1, int sum2, int len,int[][] mem) {
        
        if(idx == len) {
            return sum1==sum2?sum1:-2;
        }
        if(mem[idx][Math.abs(sum1-sum2)]!=-1) {
            return mem[idx][Math.abs(sum1-sum2)] == -2 ? -2 : Math.max(sum1,sum2) + mem[idx][Math.abs(sum1-sum2)];
        } 
       int currMax = Math.max(getMaxHeight(rods,idx+1,sum1+rods[idx],sum2,len,mem), Math.max(getMaxHeight(rods, idx+1,sum1,sum2+rods[idx],len,mem),getMaxHeight(rods,idx+1,sum1,sum2,len,mem))); 
        mem[idx][Math.abs(sum1-sum2)] = currMax==-2?currMax:currMax-Math.max(sum1,sum2);
        return mem[idx][Math.abs(sum1-sum2)] == -2 ? -2 : Math.max(sum1,sum2) + mem[idx][Math.abs(sum1-sum2)];
        
    }
    public int tallestBillboard(int[] rods) {
        int[][] mem = new int[rods.length][5000];
        for(int i=0;i<rods.length;i++) {
            for(int j=0;j<5000;j++) {
                mem[i][j] = -1;
            }
        }
        
        return Math.max(0,getMaxHeight(rods,0,0,0,rods.length,mem));
    }
}