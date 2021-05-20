/* Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively. */

class Solution {
    private int getScore(String s, int[] score) {
        int total = 0;
        for(int i=0;i<s.length();i++) {
            total+=score[s.charAt(i)-'a'];
        }
        return total;
    }
    private boolean isPossible(String s,int[] freq) {
        for(int i=0;i<s.length();i++) {
            if(freq[s.charAt(i)-'a']==0) {
                return false;
            }
            freq[s.charAt(i)-'a']--;
        }
        return true;
    }
    private int getMaxScore(int curr,int prevMaxm,String[] words,int[] freq,int[] score) {
        int currMax = prevMaxm+getScore(words[curr],score);
        int maxm = currMax;
        for(int i=curr+1;i<words.length;i++) {
            int[] temp = freq.clone();
            if(isPossible(words[i],temp)) {
                maxm = Math.max(maxm,getMaxScore(i,currMax,words,temp,score));
            }
            
        }
        return maxm;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int[] freq = new int[26];
        for(int i=0;i<letters.length;i++) {
            freq[letters[i]-'a']++;
        }
        int maxm = 0;
        for(int i=0;i<words.length;i++) {
            int[] temp = freq.clone();
            if(isPossible(words[i],temp)) {
                maxm = Math.max(maxm,getMaxScore(i,0,words,temp,score));
            }
        }
        return maxm;
    }
}