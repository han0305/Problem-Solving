/* Given a roman numeral, convert it to an integer. */

class Solution {
    int getInt(char r) {
        if(r == 'I')
            return 1;
        if(r == 'V')
            return 5;
        if(r == 'X')
            return 10;
        if(r == 'L')
            return 50;
        if(r == 'C')
            return 100;
        if(r == 'D')
            return 500;
        else 
            return 1000;
    }
    
    public int romanToInt(String s) {
        if(s.length() == 0)
            return 0;
        int res = getInt(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--) {
            int currVal = getInt(s.charAt(i));
            int prevVal = getInt(s.charAt(i+1));
            if(currVal>=prevVal) {
                res+=currVal;
            }
            else {
                res-=currVal;
            }
        }
        return res;
    }
}