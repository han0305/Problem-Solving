/* A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "111" can have each of its "1"s be mapped into 'A's to make "AAA", or it could be mapped to "11" and "1" ('K' and 'A' respectively) to make "KA". Note that "06" cannot be mapped into 'F' since "6" is different from "06".

Given a non-empty string num containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer. */

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0]  = s.charAt(0) == '0' ? 0:1;
        for(int i = 1;i<n;i++) {
            int j = i-1;
            int currNo = s.charAt(i) - '0';
            int prevNo = s.charAt(i-1) - '0';
            if(currNo>0) {
                dp[i]+=dp[i-1];
            }
            if(prevNo>0) {
                int newNo = prevNo*10+currNo;
                if(newNo <= 26 && i-2>=0) {
                    dp[i]+=dp[i-2];
                }
                else if(newNo<=26) {
                    dp[i]+=1;
                }
            }
        }
        
        return dp[n-1];
    }
}