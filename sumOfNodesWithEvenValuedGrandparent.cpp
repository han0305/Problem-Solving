/* Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0. */

class Solution {
    int getSum(TreeNode* root,int grandParentVal,int parentVal) {
        if(root == NULL)
            return 0;
        int sum = 0;
        if(grandParentVal%2 == 0)
            sum+=root->val;
        grandParentVal=parentVal;
        parentVal = root->val;
        return sum + getSum(root->left,grandParentVal,parentVal) +  getSum(root->right,grandParentVal,parentVal);    
    }
    
public:
    int sumEvenGrandparent(TreeNode* root) {
        if(root == NULL) 
            return 0;
        int gpv = root->val;
        int sum = 0;
        if(root->left) {
            sum+=getSum(root->left->left,gpv,root->left->val);
            sum+=getSum(root->left->right,gpv,root->left->val);
        }
        if(root->right) {
            sum+=getSum(root->right->left,gpv,root->right->val);
            sum+=getSum(root->right->right,gpv,root->right->val);
        }
        return sum;
    }
};