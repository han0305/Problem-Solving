class Solution {
public:
    bool isSame(TreeNode* s, TreeNode* t) {
        if(t==NULL && s==NULL) {
            return true;
        }
        if(s == NULL) {
            return false;
        }
        if(t == NULL) {
            return false;
        }
        if(t->val != s->val) {
            return false;
        }
        return isSame(s->left,t->left) && isSame(s->right,t->right);
    }
    bool isSubTreeUtil(TreeNode* s, TreeNode* t){
        if(s== NULL) {
            return false;
        }
        if(s->val == t->val) {
            if(isSame(s,t)) {
                return true;
            }
        }
        return isSubTreeUtil(s->left,t) || isSubTreeUtil(s->right,t);
    }
    bool isSubtree(TreeNode* s, TreeNode* t) {
        if(t==NULL) {
            return true;
        }
        return isSubTreeUtil(s,t);
    }
};