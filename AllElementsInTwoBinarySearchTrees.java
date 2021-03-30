/* Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order. */

class Solution {
    
    void inorder(TreeNode root,List<Integer> flat) {
        if(root == null)
            return;
        LinkedList<TreeNode> st = new LinkedList<TreeNode>();
        st.push(root);
        while(!st.isEmpty()) {
            
            while(root!=null && root.left!=null) {
                root = root.left;
                st.push(root);
            }
            
            root = st.pop();
            flat.add(root.val);
            if(root.right!=null) {
                root = root.right;
                st.push(root);
            }
            else {
                root = null;
            }
            
            
            
        }
        
        
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        inorder(root1,l1);
        inorder(root2,l2);
        
        List<Integer> res =  new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        
        while(i<l1.size() || j<l2.size()) {
            if(i == l1.size()) 
                res.add(l2.get(j++));
            else if(j == l2.size())
                res.add(l1.get(i++));
            else if(l1.get(i) <= l2.get(j)) {
                
                res.add(l1.get(i++));
            }
            else {
                res.add(l2.get(j++));
            }
        }
        
        return res;
    }
}

