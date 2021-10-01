/* Given the root of a binary tree, return the sum of all left leaves. */

class Solution {
    private int getSum(TreeNode root, boolean isLeft) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return getSum(root.left,true) + getSum(root.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root.left,true) + getSum(root.right,false);
    }
}