/* Given a string S, return the number of substrings of length K with no repeated characters. */

class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] freq = new int[26];
        Arrays.fill(freq,-1);
        int j=0;
        int count = 0;
        for(int i=0;i<S.length();i++) {
            int no = S.charAt(i)-'a';
            if(freq[no] >= j) {
                j=freq[no]+1;
            }
            if(i-j+1 == K) {
                count++;
                j++;
            }
            freq[no]=i;
        }
        return count;
    }
}