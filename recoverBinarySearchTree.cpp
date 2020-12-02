/* You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? */

class Solution {
public:
    void recoverTree(TreeNode* root) {
        if(root == NULL)
            return;
        stack<TreeNode*> st;
        st.push(root);
        TreeNode *swap1,*swap2;
        swap1 = swap2 = NULL;
        while(!st.empty()) {
            if(root && root->left) {
                st.push(root->left);
                root=root->left;
            }
            else {
                root = st.top();
                st.pop();
                if(swap2!=NULL ) {
                    if(root->val < swap2->val) {
                        swap2 = root;
                        break;
                    }
                }
                else {
                  if(swap1 == NULL) {
                      swap1 = root;
                  }
                  else if(swap1->val>root->val) {
                      swap2 = root;
                  }
                  else {
                      swap1 = root;
                  }
                }
                if(root->right)
                    st.push(root->right);
                root = root->right;
            }
        }
        if(swap1!=NULL && swap2!=NULL) {
            int temp = swap1->val;
            swap1->val = swap2->val;
            swap2->val = temp;
        }
    } 
};