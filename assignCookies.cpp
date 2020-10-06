/*  Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive.
You cannot assign more than one cookie to one child.  */

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        
        sort(g.begin(),g.end(),greater<int>());
        sort(s.begin(),s.end(),greater<int>());
        
        int count = 0;
        int i=0;
        int j=0;
        int l1 = g.size();
        int l2 = s.size();
        
        while(i<l1 && j<l2) {
            if(g[i]<=s[j]) {
                count++;
                i++;
                j++;
            }
            else 
                i++;
            
            
        }
        
        
        return count;
    }
};