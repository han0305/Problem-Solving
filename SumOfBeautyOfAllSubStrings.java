/* The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings. */

class Solution {
    
    private int getBeauty(int[] freq) {
        
        int minm = Integer.MAX_VALUE;
        int maxm = Integer.MIN_VALUE;
        
        for(int i=0;i<freq.length;i++) {
            if(freq[i]!=0) {
                maxm = Math.max(maxm,freq[i]);
                minm = Math.min(minm,freq[i]);
            }
        }
        return maxm-minm;
    }
    public int beautySum(String s) {
        
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            int[] freq = new int[26];
            for(int j = i;j<s.length();j++) {
                
                freq[s.charAt(j)-'a']++;
                sum+=getBeauty(freq);
                
            }
            
        }
        
        return sum;
    }
}