/* Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer. */

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        String[] words = text.split(" ");
        ArrayList<String> l = new ArrayList<String>();
        for(int i=1;i<words.length;i++) {
            
            if(words[i-1].equals(first) && words[i].equals(second)) {
                if(i+1<words.length) {
                    l.add(words[i+1]);
                }
            }
            
        }
        
        String[] res = new String[l.size()];
        for(int i=0;i<l.size();i++) {
            res[i] = l.get(i);
        }
        
        return res;
    }
}