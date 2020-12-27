/* A binary tree is given such that each node contains an additional random pointer which could point to any node in the tree or null.

Return a deep copy of the tree.

The tree is represented in the same input/output way as normal binary trees where each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point to any node.
You will be given the tree in class Node and you should return the cloned tree in class NodeCopy. NodeCopy class is just a clone of Node class with the same attributes and constructors. */


class Solution {
public:
     NodeCopy* getDeepCopy(Node* root,unordered_map<Node*,NodeCopy*>& hm) {
        
        if(root == NULL) 
            return NULL;
        NodeCopy* newNode;
        if(hm.find(root) != hm.end()) {
            newNode = hm[root];
        }
        else {
            newNode = new NodeCopy(root->val);
        }
        hm[root] = newNode;
        newNode->left = getDeepCopy(root->left,hm);
        newNode->right = getDeepCopy(root->right,hm);
        if(hm.find(root->random)!=hm.end()) {
            newNode->random = hm[root->random];
        }
        else 
        newNode->random = getDeepCopy(root->random,hm);
        
         return newNode;
        
    }
    NodeCopy* copyRandomBinaryTree(Node* root) {
       unordered_map<Node*,NodeCopy*> hm;
       NodeCopy* copyRoot = getDeepCopy(root,hm);
       return copyRoot; 
    }
};