/* We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order. */

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        
        String[] l1 = A.split(" ");
        String[] l2 = B.split(" ");
        int i=0;
        int j=0;
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        
        while(i<l1.length || j<l2.length) {
            
            if(i<l1.length) {
                
                int freq = hm.getOrDefault(l1[i],0) + 1;
                hm.put(l1[i++],freq);
            }
            
            if(j<l2.length) {
                
                int freq = hm.getOrDefault(l2[j],0) + 1;
                hm.put(l2[j++],freq);
            }
        }
        
        ArrayList<String> al = new ArrayList<String>();
        
        for(Map.Entry<String,Integer> mp : hm.entrySet()) {
            
            int val = mp.getValue();
            
            if(val==1) {
                
                al.add(mp.getKey());
                
            }
            
        }
        
        String[] res = new String[al.size()];
        
        for(int k=0;k<al.size();k++) {
            
            res[k] = al.get(k);
        }
        
        return res;
    }
}