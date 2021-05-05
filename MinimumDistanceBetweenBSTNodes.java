/* Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree. */

class Solution {
    private void inorder(TreeNode root, ArrayList<Integer> al) {
        if(root==null)
            return;
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
        
    }
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        inorder(root, al);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<al.size();i++) {
            if(al.get(i)-al.get(i-1)<minDiff) {
                minDiff = al.get(i)-al.get(i-1);
            }
        }
        return minDiff;
    }
}