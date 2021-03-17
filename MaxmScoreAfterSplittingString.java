/* Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.

  */

  class Solution {
    public int maxScore(String s) {
        
        int oneCount = 0;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '1')
                oneCount++;
        }
        
        int zeroCount = 0;
        int maxScore = Integer.MIN_VALUE;
        
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i) == '0')
                zeroCount++;
            else if(s.charAt(i) == '1')
                oneCount--;
            int currScore = zeroCount + oneCount;
            maxScore = Math.max(maxScore,currScore);
        }
        
        return maxScore;
    }
}