/* Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B. */

class Solution {
    int getMaxDiff(TreeNode root, int maxm, int minm) {
        
        if(root == null) {
            return maxm-minm;
        }
        maxm = Math.max(maxm,root.val);
        minm = Math.min(minm,root.val);
        return Math.max(getMaxDiff(root.left,maxm,minm),getMaxDiff(root.right,maxm,minm));
        
    }
    public int maxAncestorDiff(TreeNode root) {
        return getMaxDiff(root,root.val,root.val);
    }
}