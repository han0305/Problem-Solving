/* Given a binary string s (a string consisting only of '0' and '1's).

Return the number of substrings with all characters 1's.

Since the answer may be too large, return it modulo 10^9 + 7. */

class Solution {
public:
    int numSub(string s) {
        int count = 0;
        int l = s.length();
        int j=0;
        for(int i=0;i<l;i++) {
            if(s[i] == '1') {
                count = (count+(i-j+1))%1000000007;
            }
            else {
                j=i+1;
            }
        }
        return count;
    }
};