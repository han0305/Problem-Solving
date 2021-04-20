/* Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function. */

class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] res = new int[s.length()];
        int prev = Integer.MAX_VALUE;
        
        for(int i=0;i<s.length();i++) {
            
            if(s.charAt(i) == c) {
                prev = i;
                continue;
            }
            res[i] = Math.abs(prev-i);
        }
        
        for(int i=s.length()-1;i>=0;i--) {
            
            if(s.charAt(i) == c) {
                prev = i;
                continue;
            }
            res[i] = Math.min(res[i],Math.abs(prev-i));
            
        }
        
        return res;
    }
}