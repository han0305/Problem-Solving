/* Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children. */

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0)
            return new ArrayList<TreeNode>(); 
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(n==1) {
            res.add(new TreeNode(0));
            return res;
        }
        for(int i=1;i<n-1;i=i+2) {
            List<TreeNode> leftComb = allPossibleFBT(i);
            List<TreeNode> rightComb = allPossibleFBT(n-1-i);
            for(int j=0;j<leftComb.size();j++) {
                for(int k=0;k<rightComb.size();k++) {
                    TreeNode newNode = new TreeNode(0);
                    newNode.left=leftComb.get(j);
                    newNode.right=rightComb.get(k);
                    res.add(newNode);
                }
            }
        }
        return res;
    }
}