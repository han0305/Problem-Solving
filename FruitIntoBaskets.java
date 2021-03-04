/* In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure? */

class Solution {
    public int totalFruit(int[] tree) {
        
        if(tree.length<2)
            return tree.length;
        int first = 0;
        int second = -1;
        int count = 1;
        int i = 1;
        int maxm = 1;
        while(i<tree.length) {
            if(tree[i] == tree[first]) {
                if(tree[i-1] != tree[first])
                    first = i;
                count++;
            }
            else if(second == -1) {
                second = i;
                count++;
            }
            else if(tree[i] == tree[second]) {
                if(tree[i-1]!=tree[second])
                    second = i;
                count++;
            }
            else {
                count = 1;
                if(tree[i-1] == tree[first]) {
                    count+=((i-1)-first)+1;
                }
                else {
                    count+=((i-1)-second)+1;
                }
                first = i-1;
                second = i;
                
            }
            maxm = Math.max(maxm,count);
            i++;
            
        }
        return maxm;
    }
}