/* You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating. */

class Solution {
    public int minOperations(String s) {
        
        char startZeroDigit = '0';
        char startOneDigit = '1';
        int  startZeroCost = 0;
        int  startOneCost = 0;
        
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) != startZeroDigit)
                startZeroCost++;
            
            if(s.charAt(i) != startOneDigit) 
                startOneCost++;
            
            if(startZeroDigit == '1')
                startZeroDigit = '0';
            else 
                startZeroDigit = '1';
            
            if(startOneDigit == '1')
                startOneDigit = '0';
            else 
                startOneDigit = '1';
            
        }
        return Math.min(startZeroCost,startOneCost);
    }
}