/* Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad". */

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        int count = 0;
        int prev = -1;
        int[] freq = new int[26];
        boolean isPossible = false;
        for(int i=0;i<A.length();i++) {
            
            if(A.charAt(i)  == B.charAt(i)) {
                freq[A.charAt(i)-'a']++;
                if(freq[A.charAt(i)-'a'] == 2)
                    isPossible = true;
                continue;
                
            }
            if(count == 0){
                prev =i;
                count++;
            }
            else if(count == 1) {
                if(A.charAt(i) == B.charAt(prev) && A.charAt(prev) == B.charAt(i)) {
                    count++;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
            
        }
        if(count == 1)
            return false;
        return count == 2 || isPossible;
    }
}