/* You are given a string num, which represents a large integer. You are also given a 0-indexed integer array change of length 10 that maps each digit 0-9 to another digit. More formally, digit d maps to digit change[d].

You may choose to mutate any substring of num. To mutate a substring, replace each digit num[i] with the digit it maps to in change (i.e. replace num[i] with change[num[i]]).

Return a string representing the largest possible integer after mutating (or choosing not to) any substring of num.

A substring is a contiguous sequence of characters within the string. */

class Solution {
    public String maximumNumber(String num, int[] change) {
        
        StringBuilder sb = new StringBuilder();
        boolean changed = false;
        boolean canChange = true;
        int i=0;
        for(i=0;i<num.length();i++) {
            int no = num.charAt(i)-'0';
            int toNo = change[no];
            if(no<toNo && canChange) {
                sb.append((char)(toNo+'0'));
                changed = true;
            }
            else {
                if(no == toNo) {
                    sb.append(num.charAt(i));
                    continue;
                }
                else if(changed) {
                    canChange = false;
                }
                sb.append(num.charAt(i));
                
            }
        }
        return new String(sb);
    }
}