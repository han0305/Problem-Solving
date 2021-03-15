/* You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false. */

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        int count = 0;
        int lastIndex = -1;
        
        for(int i=0;i<s1.length();i++) {
            
            if(s1.charAt(i) != s2.charAt(i)) {
                
                if(count==2)
                    return false;
                if(count==0) {
                    lastIndex = i;
                    count++;
                }
                else if(s1.charAt(i) == s2.charAt(lastIndex) 
                        && s1.charAt(lastIndex) == s2.charAt(i)) {
                    count++;
                    
                }
                else {
                    return false;
                }
                
            }
        }
        if(count == 1)
            return false;
        return true;
    }
}