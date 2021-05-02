/* Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). */

class Solution {
    
    private int getSums(TreeNode root, HashMap<Integer,Integer> hm) {
        
        if(root==null) {
            return 0;
        }
        int subtreeSum = root.val+getSums(root.left,hm)+getSums(root.right,hm);
        int freq = hm.getOrDefault(subtreeSum,0)+1;
        hm.put(subtreeSum,freq);
        return subtreeSum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        getSums(root,hm);
        int maxFreq = Integer.MIN_VALUE;
        int count = 0;
        for(Map.Entry<Integer,Integer> e : hm.entrySet()) {
            if(e.getValue() == maxFreq) {
                count++;
            }
            else if(e.getValue()>maxFreq) {
                count = 1;
                maxFreq = e.getValue(); 
            }
        }
        int[] res = new int[count];
        int idx = 0;
        for(Map.Entry<Integer,Integer> e : hm.entrySet()) {
            if(e.getValue() == maxFreq) {
                res[idx++] = e.getKey();
            }
        }
        
        return res;
    }
}