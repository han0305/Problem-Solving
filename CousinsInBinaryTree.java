/* In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins. */

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        ArrayDeque<TreeNode> q = new ArrayDeque();
        q.offer(root);
        boolean isCousin = false;
        boolean done = false;
        while(!q.isEmpty()) {
            int n = q.size();
            TreeNode parent = null;
            for(int i=0;i<n;i++) {
                root = q.poll();
                if(root.left!=null) {
                    if(root.left.val == x || root.left.val == y) {
                        if(parent!=null) {
                            if(root.val != parent.val) {
                                isCousin = true;
                            }
                            done = true;
                            break;
                        }
                        else {
                            parent = root;
                        }
                    }  
                    q.offer(root.left);
                }
                if(root.right!=null) {
                    if(root.right.val == x || root.right.val == y) {
                        if(parent!=null) {
                            if(root.val != parent.val) {
                                isCousin = true;
                            }
                            done = true;
                            break;
                        }
                        else {
                            parent = root;
                        }
                    }
                    q.offer(root.right);
                }
                if(done)
                    break;
                
            }
            
        } 
        return isCousin;
    }
}