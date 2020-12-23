/* Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

class Solution {
    public int reverse(int x) {
        int sign = x>0?1:-1;
        x*=sign;
        int newno = 0;
        while(x>0) {
            int rem = x%10;
            x = x/10;
            int temp = newno;
            newno = newno*10+rem;
            if((newno-rem)/10 != temp)
                return 0;
        }
        
        return newno*sign;
        
    }
}