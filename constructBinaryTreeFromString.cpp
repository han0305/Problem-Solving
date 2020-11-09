/* You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists. */

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
    TreeNode* str2tree(string s) {
        int l = s.length();
        if(l==0)
            return NULL;
        stack<TreeNode*> st;
        TreeNode* node = NULL;
        int i = 0;
        while(i<l) {
            
            if(s[i] == '-' || isdigit(s[i])) {
                int sign = s[i] == '-'?-1:1;
                int val = 0;
                i = s[i]=='-'?i+1:i;
                while(i<l && isdigit(s[i])) {
                    val = val*10+(s[i]-'0');
                    i++;
                }
                val = val*sign;
                node = new TreeNode(val);
                st.push(node);
            }
            else if(s[i]==')') {
                node = st.top();
                st.pop();
                if(st.top()->left == NULL){
                    st.top()->left=node;
                }
                else 
                    st.top()->right=node;
                i++;
            }
            else i++;
        }
        
        return st.top();
    }
};