/* Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.

For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies. */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int maxm = Integer.MIN_VALUE;
        
        for(int i=0;i<candies.length;i++) {
            maxm = Math.max(maxm,candies[i]);
        }
        
        List<Boolean> res = new ArrayList<>();
        
        for(int i=0;i<candies.length;i++) {
            
            if(candies[i]+extraCandies>=maxm){
                res.add(true);
            }
            else {
                res.add(false);
            }
        }
        
        return res;
    }
}