/* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target. */

class Solution {
    
    private int getClosest(TreeNode root,double target) {
        int currVal = root.val;
        
        if(target>currVal && root.right!=null) {
           int recVal = getClosest(root.right,target);
           if(Math.abs(currVal-target) < Math.abs(recVal-target))
               return currVal;
            return recVal;
        }
        else if(target<currVal && root.left!=null) { 
            int recVal = getClosest(root.left,target);
            if(Math.abs(currVal-target) < Math.abs(recVal-target))
               return currVal;
            return recVal;
            
        }
        return currVal;
    }
    public int closestValue(TreeNode root, double target) {
        return getClosest(root,target);
    }
}