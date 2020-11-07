/* We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].

We want to place these books in order onto bookcase shelves that have total width shelf_width.

We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width), then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down.  We repeat this process until there are no more books to place.

Note again that at each step of the above process, the order of the books we place is the same order as the given sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.

Return the minimum possible height that the total bookshelf can be after placing shelves in this manner. */

class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelf_width) {
        
         int l = books.size();
        vector<int> dp(l+1,0);
        dp[0] = 0;
        for(int i=1;i<=l;i++) {
            
            int currHeight = books[i-1][1];
            int currWidth = books[i-1][0];
            dp[i] = currHeight+dp[i-1];
            for(int j = i-1;j>=1 && currWidth+books[j-1][0]<=shelf_width;j--) {
              
                currHeight = max(currHeight,books[j-1][1]);
                currWidth+=books[j-1][0];
                dp[i] = min(dp[i],dp[j-1]+currHeight);
                
            }
            
            
        }
        return dp[l];
        
    }
};