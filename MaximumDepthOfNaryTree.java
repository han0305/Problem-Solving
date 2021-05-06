/* Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value. */

class Solution {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int maxm = 0;
        for(int i=0;i<root.children.size();i++) {
            maxm = Math.max(maxm,maxDepth(root.children.get(i)));
        }
        
        return maxm+1;
    }
}