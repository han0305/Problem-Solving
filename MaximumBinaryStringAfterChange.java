/* You are given a binary string binary consisting of only 0's or 1's. You can apply each of the following operations any number of times:

Operation 1: If the number contains the substring "00", you can replace it with "10".
For example, "00010" -> "10010"
Operation 2: If the number contains the substring "10", you can replace it with "01".
For example, "00010" -> "00001"
Return the maximum binary string you can obtain after any number of operations. Binary string x is greater than binary string y if x's decimal representation is greater than y's decimal representation. */

class Solution {
    public String maximumBinaryString(String binary) {
        StringBuilder res = new StringBuilder(binary);
        int zeroIdx = -1;
        
        for(int i=0;i<res.length();i++) {
            if(res.charAt(i) == '0' && zeroIdx == -1) {
                zeroIdx = i;
            }
            else if(res.charAt(i) == '0' && i-zeroIdx == 1) {
                res.setCharAt(zeroIdx,'1');
                zeroIdx = i;
            }
            else if(res.charAt(i) == '0') {
                res.setCharAt(zeroIdx,'1');
                res.setCharAt(zeroIdx+1,'0');
                res.setCharAt(i,'1');
                zeroIdx++;
            }
            
            
        }
        
        return res.toString();
    }
}