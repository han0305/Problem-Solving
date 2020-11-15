/* Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false. */

class Solution {
public:
    bool isValid(string s) {
        int l = s.length();
        int countA=0;
        int countB=0;
        bool isValid = true;
        for(int i=0;i<l;i++) {
            if(s[i] == 'a') {
                countA++;
            }
            else if(s[i] == 'b') {
               if(countA>0 && (s[i-1] == 'c' || s[i-1] == 'a')) 
                  countB++;
                else {
                    isValid = false;
                    break;
                }
            }
            else {
                if(countA>0 && countB>0  && (s[i-1] == 'c' || s[i-1] == 'b')) {
                    countA--;
                    countB--;
                }
                else {
                    isValid=false;
                    break;
                }
            }
        }
        if(!isValid) {
            return isValid;
        }
        if(countA>0 || countB>0) {
            return false;
        }
        return isValid;
    }
};