/* Given the root of a binary tree, return the inorder traversal of its nodes' values. */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null)
            return res;
        ArrayDeque<TreeNode> st = new ArrayDeque();
        st.push(root);
        while(!st.isEmpty()) {
            
            if(root != null && root.left!=null) {
                st.push(root.left);
                root = root.left;
                continue;
            }
            
            root = st.pop();
            System.out.println(root.val);
            res.add(root.val);
            if(root.right!=null) {
                st.push(root.right);
                root = root.right;
                
            }
            else 
                root = null;
       }
        
      return res;  
    }
}