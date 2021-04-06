/* Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.

You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.

Return an integer array answer, where each answer[i] is the answer to the ith query. */

class Solution {
    private int getFrequency(String word) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++) {
            
            freq[word.charAt(i)-'a']++;
            
        }
        
        for(int i=0;i<26;i++) {
            if(freq[i]>0)
                return freq[i];
        }
        
        return 0;
        
    }
    
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] wordsFreq = new int[words.length];
        for(int i=0;i<words.length;i++) {
            wordsFreq[i] = getFrequency(words[i]);
        }
        
        Arrays.sort(wordsFreq);
        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length;i++) {
            
            int freq = getFrequency(queries[i]);
            int start = 0;
            int end = wordsFreq.length-1;
            
            while(start<=end) {
                
                int mid = (start+end)/2;
                if(wordsFreq[mid] == freq || wordsFreq[mid] < freq) {
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
                
            }
            res[i] = wordsFreq.length - start;
        }
        
        return res;
    }
}