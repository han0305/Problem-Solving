/* Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote. */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<magazine.length();i++) {
            int curr = hm.getOrDefault(magazine.charAt(i),0);
            hm.put(magazine.charAt(i),curr+1);
        }
        
        for(int i=0;i<ransomNote.length();i++) {
            int curr = hm.getOrDefault(ransomNote.charAt(i),0);
            if(curr == 0) {
                return false;
            }
            hm.put(ransomNote.charAt(i), curr-1);
        }
        
        return true;
    }
}