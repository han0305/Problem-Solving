/* Given a binary tree with the following rules:

root.val == 0
If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

You need to first recover the binary tree and then implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
bool find(int target) Return if the target value exists in the recovered binary tree. */

class FindElements {

    private HashSet<Integer> hs = new HashSet<>();
    private void decontaminate(TreeNode root,int val) {
        
        root.val = val;
        hs.add(val);
        if(root.left!=null) {
            decontaminate(root.left,2*val+1);
        }
        if(root.right!=null) {
            decontaminate(root.right,2*val+2);
        }
    }
    public FindElements(TreeNode root) {
        this.decontaminate(root,0);
    }
    
    public boolean find(int target) {
        return hs.contains(target);
    }
}
