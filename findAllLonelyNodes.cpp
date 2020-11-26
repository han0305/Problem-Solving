/* In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order. */

class Solution {
public:
    void lonelyNodesUtil(TreeNode* root,vector<int>& res) {
        if(root == NULL) {
            return;
        }
        if(root->left && root->right) {
            lonelyNodesUtil(root->left,res);
            lonelyNodesUtil(root->right,res);            
        }
        else if(root->right) {
            res.push_back(root->right->val);
            lonelyNodesUtil(root->right,res);
        }
        else if(root->left){
            res.push_back(root->left->val);
            lonelyNodesUtil(root->left,res);
        }
    }
    vector<int> getLonelyNodes(TreeNode* root) {
        vector<int> res;
        lonelyNodesUtil(root,res);
        return res;
        
    }
};