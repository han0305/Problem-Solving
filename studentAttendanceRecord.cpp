/* You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record. */

class Solution {
public:
    bool checkRecord(string s) {
        
        int countA = 0;
        int countL = 0;
        for(int i=0;i<s.length();i++) {
            if(s[i] == 'A') {
                countA++;
                countL=0;
            }
            else if(s[i] == 'L')
                countL++;
            else 
                countL=0;
            if(countA>1 || countL>2) 
                return false;
        }
        return true;
    }
};