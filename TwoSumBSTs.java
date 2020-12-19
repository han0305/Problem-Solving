/* Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target. */

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null)
            return false;
        if(root2 == null)
            return false;
        int sum = root1.val+root2.val;
        if(sum == target) 
            return true;
        if(sum>target)
            return twoSumBSTs(root1.left,root2,target) || twoSumBSTs(root1,root2.left,target);
        return twoSumBSTs(root1.right,root2,target) || twoSumBSTs(root1,root2.right,target);
        
        
    }
}