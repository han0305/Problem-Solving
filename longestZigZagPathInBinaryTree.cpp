/* Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right then move to the right child of the current node otherwise move to the left child.
Change the direction from right to left or right to left.
Repeat the second and third step until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree. */

class Solution {
public:
    int longestZigZagUtil(TreeNode* root,bool isRight,int& maxm) {
        
        if(root == NULL) {
            return 0;
        }
        int leftMax = longestZigZagUtil(root->left,false,maxm);
        int rightMax = longestZigZagUtil(root->right,true,maxm);
        maxm = max(maxm,max(leftMax,rightMax)+1);
        if(isRight == true)
            return leftMax+1;
        return rightMax+1;
        
    }
    int longestZigZag(TreeNode* root) {
        
        int maxm = 0;
        int leftMax = longestZigZagUtil(root->left,false,maxm);
        int rightMax = longestZigZagUtil(root->right,true,maxm);
        maxm = max(maxm,max(leftMax,rightMax)+1);
        return maxm-1;
        
    }
};