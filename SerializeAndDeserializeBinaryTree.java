/* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. */

public class Codec {

    // Encodes a tree to a single string.
    Deque<TreeNode> q = new ArrayDeque<TreeNode>();
    public String serialize(TreeNode root) {
        if(root == null) 
            return "";
        q.offer(root);
        StringBuilder s = new StringBuilder(String.valueOf(root.val));
        while(!q.isEmpty()) {
            
            TreeNode node = q.poll();
            if(node.left != null) {
                s.append(" ");
                s.append(node.left.val);
                q.offer(node.left);
            }
            else {
                s.append(" ");
                s.append("#");
            }
            if(node.right != null) {
                s.append(" ");
                s.append(node.right.val);
                q.offer(node.right);
            }
            else {
                s.append(" ");
                s.append("#");
            }
        }
       // System.out.println(s);
        return s.toString();
    }
    
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) 
            return null;
        String[] nodes = data.split(" ");
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i++]));
        q.offer(root);
        while(!q.isEmpty() && i<nodes.length) {
            TreeNode node = q.poll();
            if(!nodes[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;
            if(i<nodes.length && !nodes[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = rightNode;
                q.offer(rightNode);
                
            }
            i++;
    }
        
        
        return root;
    }
}
