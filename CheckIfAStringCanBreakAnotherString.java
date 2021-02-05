/* Given two strings: s1 and s2 with the same size, check if some permutation of string s1 can break some permutation of string s2 or vice-versa. In other words s2 can break s1 or vice-versa.

A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1. */

class Solution {
    private boolean canBreak(char[] c1,char[] c2) {
        
        int n1 = c1.length;
        int i;
        for(i=0;i<n1;i++) {
            if(c1[i]<c2[i])
                break;
        }
        return i==n1;
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean isPossible = canBreak(c1,c2);
        if(isPossible)
            return true;
        isPossible = canBreak(c2,c1);
        return isPossible;
    }
}