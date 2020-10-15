/* Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.) */

class Solution {
public:
    int monotoneIncreasingDigits(int N) {
        
        string num = to_string(N);
        int l = num.length();
        string res = "";
        for(int i=0;i<l;i++) {
            int j;
            for(j = 0;j<=9;j++) {
                char d = '0' + j;
                string temp = res+string(l-i,d);
                if(temp > num) {
                    break;
                }
            }
            
            char d = '0' + (j-1);
            res = res + string(1,d);
            
        }
        
        return stoi(res);
    }
};