/* Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes. */

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
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        if(root == NULL) 
            return {{}};
        queue<pair<TreeNode*,int>> q;
        map<int,vector<int>> depthMp;
        map<int,vector<int>> levelMp;
        q.push(make_pair(root,0));
        levelMp[0].push_back(root->val);
        q.push({NULL,0});
        while(!q.empty()) {
            pair<TreeNode*,int> curr = q.front();
            q.pop();
            if(curr.first == NULL) {
                for(auto i : levelMp ) {
                    sort(i.second.begin(),i.second.end());
                    depthMp[i.first].insert(depthMp[i.first].end(),i.second.begin(),i.second.end());
                    
                }
                levelMp.clear();
                if(!q.empty()) {
                    q.push({NULL,0});
                }
                continue;
            }
            if(curr.first->left) {
                q.push(make_pair(curr.first->left,curr.second-1));
                levelMp[curr.second-1].push_back(curr.first->left->val);
            }
            if(curr.first->right) {
                q.push(make_pair(curr.first->right,curr.second+1));
                levelMp[curr.second+1].push_back(curr.first->right->val);
            }
            
        }
        vector<vector<int>> res;
        for(auto i : depthMp) {
            res.push_back(i.second);
        }
        return res;
    }
};