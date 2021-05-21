/* Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples). */

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        ArrayDeque<Node> q = new ArrayDeque<Node>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        q.offer(root);
        while(!q.isEmpty()) {
            
            ArrayList<Integer> curr = new ArrayList<Integer>();
            int n = q.size();
            for(int i=0;i<n;i++) {
                Node currNode = q.poll();
                curr.add(currNode.val);
                for(int j = 0;j<currNode.children.size();j++) {
                    q.offer(currNode.children.get(j));
                }
            }
            res.add(curr);
        }
        return res;
    }
}