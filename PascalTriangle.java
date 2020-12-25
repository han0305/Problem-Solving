/* Given a non-negative integer numRows, generate the first numRows of Pascal's triangle. */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if(numRows == 0)
            return res;
        res.add( new ArrayList());
        res.get(0).add(1);
        for(int i=1;i<numRows;i++) {
            res.add(new ArrayList());
            res.get(i).add(1);
            for(int j=1;j<=i;j++) {
                int sum = 0;
                if(j-1>=0) {
                    sum+=res.get(i-1).get(j-1);
                    
                }
                if(j<res.get(i-1).size()) {
                    sum+=res.get(i-1).get(j);
                }
                res.get(i).add(sum);
            }
        }
        return res;
    }
}