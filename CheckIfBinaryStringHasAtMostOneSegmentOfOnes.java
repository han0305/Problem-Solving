/* Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false. */

class Solution {
    public boolean checkOnesSegment(String s) {
        
        int i = 0;
        while(i<s.length() && s.charAt(i) == '1') {
            i++;
        }
        
        while(i<s.length()) {
            if(s.charAt(i) == '1')
                return false;
            i++;
        }
        
        return true;
    }
}