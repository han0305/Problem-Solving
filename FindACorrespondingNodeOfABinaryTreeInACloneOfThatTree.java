/* Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree. */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if(cloned == null)
            return null;
        if(target.val == cloned.val)
            return cloned;
        TreeNode res = getTargetCopy(original.left,cloned.left,target);
        if(res!=null)
            return res;
        res = getTargetCopy(original.right,cloned.right,target);
        return res;
        
    }
}