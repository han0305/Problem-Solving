/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val. */

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        boolean found = false;;
        ArrayDeque<TreeNode> st = new ArrayDeque<TreeNode>();
        st.push(root);
        while(!st.isEmpty()) {
            if(root!=null  && root.left!=null) {
                st.push(root.left);
                root = root.left;
            }
            else {
                if(!st.isEmpty())
                root = st.pop();
                else 
                    break;
                if(found == true) 
                    return root;
                if(root.val == p.val) {
                    found = true;
                }
                if(root.right!=null) {
                    st.push(root.right);
                    root = root.right;
                }
                else {
                    root = null;
                }
            }
            
            
        }
      return null;  
    }
}