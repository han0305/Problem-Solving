/* You are given a string s consisting of n characters which are either 'X' or 'O'.

A move is defined as selecting three consecutive characters of s and converting them to 'O'. Note that if a move is applied to the character 'O', it will stay the same.

Return the minimum number of moves required so that all the characters of s are converted to 'O'. */

class Solution {
    public int minimumMoves(String s) {
        int curr = 0;
        int moves = 0;
        int j = -1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'X') {
                curr++;
                if(j == -1) {
                    j = i;
                }
            }
            if(i-j+1==3 && curr > 0) {
                moves++;
                j = -1;
                curr = 0;
            }
            
        }
        if(curr>0) {
            moves++;
        }
        return moves;
    }
}