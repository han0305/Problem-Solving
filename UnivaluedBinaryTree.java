/* A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued. */

class Solution {
    private boolean checkValues(TreeNode root, int val) {
        
        if(root == null) 
            return true;
        if(root.val!=val)
            return false;
        return checkValues(root.left,val) && checkValues(root.right,val);
        
    }
    public boolean isUnivalTree(TreeNode root) {
        
        int val = root.val;
        return checkValues(root,val);
    }
}