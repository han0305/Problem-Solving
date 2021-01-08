/* Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list. */

class Solution {
    public Node treeToDoublyList(Node root) {
        
        if(root == null)
            return null;
        ArrayDeque<Node> st = new ArrayDeque();
        st.push(root);
        Node start = null;
        Node last = null;
        while(!st.isEmpty()) {
            
            if(root!=null && root.left!=null) {
                st.push(root.left);
                root = root.left;
                continue;
            }
            root = st.pop();
            if(start == null) {
                start = root;
            }
            else {
                last.right = root;
                root.left = last;
            }
            last  = root;
            if(root.right != null) {
                st.push(root.right);
                root = root.right;
            }
            else {
                root = null;
            }
        }
        
        start.left = last;
        last.right = start;
        return start;
        
    }
}