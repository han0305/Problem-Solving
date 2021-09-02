/* Given a sentence text (A sentence is a string of space-separated words) in the following format:

First letter is in upper case.
Each word in text are separated by a single space.
Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.

Return the new text following the format shown above. */

class Solution {
    public String arrangeWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        for(int i=0;i<text.length();i++) {
            if(text.charAt(i) == ' ') {
                words.add(curr.toString());
                curr = new StringBuilder();
                continue;
            }
            curr.append(text.charAt(i));
        }
        words.add(curr.toString());
        Collections.sort(words, (String s1, String s2) -> s1.length()-s2.length());
        String res = new String();
        for(int i=0;i<words.size();i++) {
            if(i == 0) {
                StringBuilder word = new StringBuilder(words.get(i));
                word.setCharAt(0,Character.toUpperCase(word.charAt(0)));
                res = res.concat(word.toString());
            }
            else {
                StringBuilder word = new StringBuilder(words.get(i));
                word.setCharAt(0,Character.toLowerCase(word.charAt(0)));
                res = res.concat(word.toString());
            }
            if(i+1!=words.size()) {
                res = res.concat(" ");
            }
        }
        
        return res;
    }
}