/* You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order. */

class Solution {
    
    private boolean isPermutation(String word, String pattern) {
        
        HashMap<Character,Character> hm1 = new HashMap<Character,Character>();
        HashMap<Character,Character> hm2 = new HashMap<Character,Character>();
        int n = word.length();
        
        for(int i=0;i<n;i++) {
            
            if(hm1.containsKey(word.charAt(i)) && hm2.containsKey(pattern.charAt(i))) {
                
                if(hm1.get(word.charAt(i))!= pattern.charAt(i) || hm2.get(pattern.charAt(i))!=word.charAt(i)) {
                    
                    return false;
                }
            }
            else if(!hm1.containsKey(word.charAt(i)) && !hm2.containsKey(pattern.charAt(i))) {
                
                hm1.put(word.charAt(i),pattern.charAt(i));
                hm2.put(pattern.charAt(i),word.charAt(i));
            }
            else if(!hm1.containsKey(word.charAt(i))) {
                
                return false;
            }
            else if(!hm2.containsKey(pattern.charAt(i))) {
                
                return false;
            }
            
            
        }
        
        return true;
    }
    
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        ArrayList<String> res = new ArrayList<String>();
        int n = words.length;
        
        for(int i=0;i<n;i++) {
            
            if(isPermutation(words[i], pattern)) {
                res.add(words[i]);
            }
        }
        
        return res;
    }
}