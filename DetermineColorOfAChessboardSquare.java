/* You are given coordinates, a string that represents the coordinates of a square of the chessboard. Return true if the square is white, and false if the square is black.

The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second. */

class Solution {
    public boolean squareIsWhite(String coordinates) {
        
        int x = (coordinates.charAt(0)-'a')+1;
        int y = coordinates.charAt(1)-'0';
        
        if(x%2==0 && y%2==0)
            return false;
        if(x%2!=0 && y%2!=0)
            return false;
        return true;
    }
}