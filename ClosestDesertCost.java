/* You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:

There must be exactly one ice cream base.
You can add one or more types of topping or have no toppings at all.
There are at most two of each type of topping.
You are given three inputs:

baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base flavor.
toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith topping.
target, an integer representing your target price for dessert.
You want to make a dessert with a total cost as close to target as possible.

Return the closest possible cost of the dessert to target. If there are multiple, return the lower one. */

class Solution {
    int res = -1;
    private void addToppings(int idx, int[] toppingCosts, int curr,int target) {
        
        if(idx == toppingCosts.length) 
            return;
        for(int i=0;i<=2;i++) {
            
            curr+=i*toppingCosts[idx];
            if(Math.abs(target - curr) < Math.abs(target-res)) 
                res = curr;
            else if(Math.abs(target - curr) == Math.abs(target-res) && curr<res) 
                res = curr;
            addToppings(idx+1,toppingCosts,curr,target);
            curr-=i*toppingCosts[idx];
        }
        
        
    }
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        for(int i = 0;i<baseCosts.length;i++) {
            int curr = baseCosts[i];
            if(res == -1) 
                res = curr;
            else if(Math.abs(target - curr) < Math.abs(target-res)) 
                res = curr;
            else if(Math.abs(target - curr) == Math.abs(target-res) && curr<res) 
                res = curr;
            addToppings(0,toppingCosts,curr,target);
        }
        
        return res;
    }
}