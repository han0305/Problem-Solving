/* Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value */

class Pair {
    Node node;
    int idx;
    Pair(Node node) {
        this.node = node;
        this.idx = 0;
    }
}
class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        ArrayDeque<Pair> st = new ArrayDeque<>();
        st.push(new Pair(root));
        while(!st.isEmpty()) {
            if(st.peek().idx < st.peek().node.children.size()) {
                int idx = st.peek().idx;
                st.peek().idx+=1;
                st.push(new Pair(st.peek().node.children.get(idx)));
            } else {
                Node curr = st.pop().node;
                res.add(curr.val);
            }
            
        }
        
        return res;
    }
}