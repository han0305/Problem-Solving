/* Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed). */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res  = new ArrayList<>();
        if(root == null)
            return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            
            int maxm = Integer.MIN_VALUE;
            int n = q.size();
            for(int i=0;i<n;i++) {
                TreeNode curr = q.poll();
                maxm = Math.max(maxm,curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            res.add(maxm);
        }
        return res;
    }
}