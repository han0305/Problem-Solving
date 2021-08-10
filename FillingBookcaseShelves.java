/* You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.

We want to place these books in order onto bookcase shelves that have a total width shelfWidth.

We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.

Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.

For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
Return the minimum possible height that the total bookshelf can be after placing shelves in this manner. */

class Solution {
    private int getMinHeight(int[][] books, int width, int idx, int[] mem) {
        if(idx == books.length) {
            return 0;
        }
        if(mem[idx]!=0) {
            return mem[idx];
        }
        int currWidth = books[idx][0];
        int currHeight = books[idx][1];
        int minHeight = Integer.MAX_VALUE;
        int i;
        for(i=idx+1;i<books.length;i++) {
            if(currWidth+books[i][0]>width) {
                break;
            }
            minHeight = Math.min(minHeight, currHeight+getMinHeight(books,width,i,mem));
            currHeight = Math.max(currHeight, books[i][1]);
            currWidth+=books[i][0];
        }
        
        return mem[idx] = Math.min(minHeight, currHeight+getMinHeight(books,width,i,mem));
    }
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] mem = new int[books.length];
        return getMinHeight(books,shelf_width,0,mem);
    }
}