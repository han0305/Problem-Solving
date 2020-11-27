/* Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)? */

class Solution {
public:
    int getNextLargest(TreeNode* root) {
        if(root->left)
            return getNextLargest(root->left);
        return root->val;
    }
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) {
            return root;
        }
        if(root->val>key) {
            root->left =  deleteNode(root->left,key);
        }
        else if(root->val<key){
           root->right = deleteNode(root->right,key);
        }
        else {
            if(root->left && root->right) {
                int val = getNextLargest(root->right);
                TreeNode* newNode = new TreeNode(val);
                newNode->left = root->left;
                newNode->right = root->right;
                delete root;
                newNode->right = deleteNode(newNode->right,val);
                return newNode;
            }
            else if(root->right) {
                TreeNode* temp = root->right;
                delete root;
                return temp;
            }
            else if(root->left) {
                TreeNode* temp = root->left;
                delete root;
                return temp;
            }
            else {
                delete root;
                return NULL;
            }
        }
        return root;
    }
};