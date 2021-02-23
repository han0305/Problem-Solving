/* Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight. */

class Solution {
    
    private int getMaxDepth(List<NestedInteger> nestedList,int currDepth) {
        currDepth++;
        int maxDepth = currDepth;
        for(int i=0;i<nestedList.size();i++) {
            if(nestedList.get(i).isInteger() == false) {
                int depth = getMaxDepth(nestedList.get(i).getList(),currDepth);
                maxDepth = Math.max(maxDepth,depth);
            }
        }
        return maxDepth;
    }
    
    private int getWeightedSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for(int i = 0;i<nestedList.size();i++) {
            if(nestedList.get(i).isInteger()) {
                sum = sum + nestedList.get(i).getInteger()*level;
            }
            else 
                sum = sum + getWeightedSum(nestedList.get(i).getList(),level-1);
        }
        return sum;
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList.size() == 0)
            return 0;
        int maxDepth = getMaxDepth(nestedList,0);
        
        return getWeightedSum(nestedList,maxDepth);
        
    }
}