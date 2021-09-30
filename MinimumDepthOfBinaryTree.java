/* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children. */

class Solution {
    private int getMinDepth(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE, rightDepth = Integer.MAX_VALUE;
        if(root.left!=null) {
            leftDepth = getMinDepth(root.left);
        }
        if(root.right!=null) {
            rightDepth = getMinDepth(root.right);
        }
        
        return 1+Math.min(leftDepth,rightDepth);
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getMinDepth(root);
    }
}