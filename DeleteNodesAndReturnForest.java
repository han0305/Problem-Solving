/* Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order. */

class Solution {
    private TreeNode deleteNodesUtil(TreeNode root, HashSet<Integer> hs, List<TreeNode> res) {
        
        if(root == null) 
            return null;
        
        root.left = deleteNodesUtil(root.left,hs,res);
        root.right = deleteNodesUtil(root.right,hs,res);
        
        if(hs.contains(root.val)) {
            
            if(root.left!=null) {
                res.add(root.left);
            }
            if(root.right!=null) {
                res.add(root.right);
            }
            return null;
        }
        
        return root;
        
        
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<to_delete.length;i++) {
            hs.add(to_delete[i]);
        }
        List<TreeNode> res = new ArrayList<TreeNode>();
        root = deleteNodesUtil(root,hs,res);
        if(root!=null)
        res.add(root);
        return res;
        
    }
}