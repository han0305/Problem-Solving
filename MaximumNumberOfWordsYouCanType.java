/* There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard. */

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        HashSet<Character> hs = new HashSet<Character>();
        for(int i=0;i<brokenLetters.length();i++) {
            hs.add(brokenLetters.charAt(i));
        }
        int count = 0;
        for(int i=0;i<words.length;i++) {
            int j = 0;
            while(j<words[i].length()) {
                if(hs.contains(words[i].charAt(j))) {
                    break;
                }
                j++;
            }
            if(j == words[i].length()) {
                count++;
            }
        }
        return count;
    }
}