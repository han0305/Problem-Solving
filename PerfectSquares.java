/* Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not. */

class Solution {
    public int numSquares(int n) {
        
        ArrayList<Integer> squares = new ArrayList<Integer>();
        int i=1;
        while(true) {
            if(i*i<=n) {
                squares.add(i*i);
                i++;
            }
            else{
                break;
            }
        }
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(0,0);
        for(i=1;i<=n;i++) {
            int minCount = Integer.MAX_VALUE;
            for(int j = squares.size()-1;j>=0;j--) {
                if(squares.get(j) <= i) {
                    int rem = i-squares.get(j);
                    if(hm.containsKey(rem)) {
                        minCount = Math.min(minCount,1+hm.get(rem));
                    }
                }
                
            }
            hm.put(i,minCount);
            
        }
        return hm.get(n);
    }
}