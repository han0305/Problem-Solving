/* Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and repeated 2 times is "abcabc". */

class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        int al = a.length();
        int bl = b.length();
        int count = 0;
        bool found = true;
        
        for(int i=0;i<al;i++) {
            
            int j = i;
            int k = 0;
            count = 1;
            while(k<bl) {
                
                if(a[j] == b[k]) {
                    j++;
                    k++;
                }
                else {
                    break;
                }
                if(j == al && k!=bl) {
                    count++;
                    j = 0;
                }
            }
            if(k == bl) {
                found = true;
                break;
            }
            else if(i == al-1) {
                found = false;
            }
            
        }
        
        return found?count:-1;
    }
};