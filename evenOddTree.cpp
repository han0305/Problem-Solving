/* A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false. */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isValid(int prev,int curr,int level) {
        
        if(level%2 == 0) {
            if(curr%2!=0 && curr>prev)
                return true;
        }
        else  {
             if(curr%2==0 && curr<prev)
                return true;
        }
        return false;
        
    }
    bool isEvenOddTree(TreeNode* root) {
        if(root == NULL) {
            return true;
        }
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        int level = 0;
        int flag = true;
        int prev = INT_MIN;
        while(!q.empty()) {
            TreeNode* root = q.front();
            q.pop();
            if(root == NULL) {
                if(!q.empty())
                q.push(NULL);
                level++;
                if(level%2 == 0) 
                    prev = INT_MIN;
                else 
                    prev = INT_MAX;
                continue;
            }
            if(isValid(prev,root->val,level)) {
                    prev = root->val;
                }
            else{
                    flag = false;
                    //cout<<root->val<<" "<<level<<endl;
                    break;
            }
            if(root->left) {
               
                q.push(root->left);
                
            }
            if(root->right) {
              
                q.push(root->right);
            }
            
            
        }
        
        return flag;
        
    }
};