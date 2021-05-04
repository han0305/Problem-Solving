/* Given the root of a binary tree, return the sum of values of its deepest leaves. */

class Solution {
    int getHeight(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
        
    }
    
    int getDeepestSumUtil(TreeNode root, int height) {
        
        if(height == 1) {
            return root.val;
        }
        int sum = 0;
        if(root.left!=null) {
            sum+=getDeepestSumUtil(root.left,height-1);
        }
        if(root.right!=null) {
            sum+=getDeepestSumUtil(root.right,height-1);
        }
        return sum;
    }
    public int deepestLeavesSum(TreeNode root) {
        
        int height = getHeight(root);
        return getDeepestSumUtil(root,height);
    }
}