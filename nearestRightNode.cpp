/*  Given the root of a binary tree and a node u in the tree, return the nearest node on the same level that is to the right of u, or return null if u is the rightmost node in its level.  */


class Solution {
public:
    TreeNode* findNearestRightNode(TreeNode* root, TreeNode* u) {
        queue<TreeNode*> q;
        int found = false;
        if(root == NULL) {
            return NULL;
        }
        q.push(root);
        q.push(NULL);
        TreeNode* res = NULL;
        while(!q.empty()) {
            
            TreeNode* root = q.front();
            q.pop();
            if(root == NULL) {
                if(found == true) {
                    break;
                }
                if(!q.empty()) {
                    q.push(NULL);
                }
            }
            else {
                if(found == true) {
                    res = root;
                    break;
                }
                else if(root == u) {
                    found = true;
                }
                if(root->left) {
                    q.push(root->left);
                }
                if(root->right) {
                    q.push(root->right);
                }
                
            }
            
        }
        return res;
    }
};