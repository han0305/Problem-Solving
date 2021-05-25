/* A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path. */

class Solution {
    int maxm = Integer.MIN_VALUE;
    
    private int maxPathSumUtil(TreeNode root) {
        maxm = Math.max(maxm,root.val);
        int totalLeftSum = root.val;
        int totalRightSum = root.val;
        int total = root.val;
        if(root.left!=null) {
            int leftSum = maxPathSumUtil(root.left);
            totalLeftSum+=leftSum;
            maxm=Math.max(maxm,Math.max(leftSum,totalLeftSum));
            total+=leftSum;
        }
        if(root.right!=null) {
            int rightSum = maxPathSumUtil(root.right);
            totalRightSum+=rightSum;
            maxm=Math.max(maxm,Math.max(rightSum,totalRightSum));
            total+=rightSum;
        }
        maxm = Math.max(maxm,total);
        if(root.val>totalLeftSum && root.val>totalRightSum) {
            return root.val;
        }
        return Math.max(totalLeftSum,totalRightSum);
        
    } 
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxm;
    }
}