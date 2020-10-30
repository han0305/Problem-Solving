/* Invert a binary tree. */

class Solution {
public:
    void invertTreeUtil(TreeNode* root) {
         if(root == NULL) {
             return ;
         }
        TreeNode* temp = root->left;
        root->left = root->right;
        root->right = temp;
        
        invertTreeUtil(root->left);
        invertTreeUtil(root->right);
        
    }
    TreeNode* invertTree(TreeNode* root) {
        invertTreeUtil(root);
        return root;
    }
};