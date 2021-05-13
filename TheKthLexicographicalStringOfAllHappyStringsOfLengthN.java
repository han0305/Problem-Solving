/* A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n. */

class Solution {
    private void getKthHappyString(StringBuilder s, ArrayList<String> al, int n, int k) {
        
        if(s.length() == n) {
            al.add(s.toString());
            return;
        }
        char[] letters = {'a','b','c'};
        for(int i=0;i<letters.length;i++) {
            if(s.length()>0 && s.charAt(s.length()-1)==letters[i])
                continue;
            s.append(letters[i]);
            getKthHappyString(s, al, n, k);
            if(al.size()==k)
                return;
            s.deleteCharAt(s.length()-1);
            
        }
    }
    public String getHappyString(int n, int k) {
        ArrayList<String> al = new ArrayList<String>();
        getKthHappyString(new StringBuilder(), al, n, k);
        return k<=al.size()?al.get(k-1):"";
    }
}