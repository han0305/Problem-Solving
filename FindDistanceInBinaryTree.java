/* Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other. */

class Solution {
    
    private boolean getPath(TreeNode root,int val,ArrayList<Integer> path) {
        if(root == null) 
            return false;
        if(root.val == val) {
            path.add(root.val);
            return true;
        }
        boolean found = getPath(root.left,val,path) || getPath(root.right,val,path);
        if(found) {
            path.add(root.val);
        }
        return found;
    }
    public int findDistance(TreeNode root, int p, int q) {
        
        ArrayList<Integer> path1 = new ArrayList();
        ArrayList<Integer> path2 = new ArrayList();
        getPath(root,p,path1);
        getPath(root,q,path2);
        int start1 = path1.size()-1;
        int start2 = path2.size()-1;
        while(start1>=0 && start2>=0) {
            int n1 = path1.get(start1);
            int n2 = path2.get(start2);
            if(n1!=n2){
                break;
            }
            start1--;
            start2--;
        }
    
    
        return start1+start2+2;
    }
}