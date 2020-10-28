/* Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note. */

class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int ml = magazine.length();
        unordered_map<char,int> freq;
        for(int i=0;i<ml;i++) {
            freq[magazine[i]]++;
        }
        int nl = ransomNote.length();
        bool isPossible = true;
        for(int i=0;i<nl;i++) {
            if(freq.find(ransomNote[i]) == freq.end()) {
                isPossible = false;
                break;
            }
            else if(freq[ransomNote[i]] == 0) {
                isPossible = false;
                break;
            }
            else {
               freq[ransomNote[i]]--; 
            }
        }
        
        return isPossible;
    }
};