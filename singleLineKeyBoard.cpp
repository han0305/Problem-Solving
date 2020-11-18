/* There is a special keyboard with all keys in a single row.

Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.

You want to type a string word. Write a function to calculate how much time it takes to type it with one finger. */

class Solution {
public:
    int calculateTime(string keyboard, string word) {
        int mp[26] = {0};
        int totalTime = 0;
        for(int i=0;i<keyboard.length();i++) {
            mp[keyboard[i]-'a'] = i;
        }
        int prev = 0;
        for(int i=0;i<word.length();i++) {
            totalTime+=abs(mp[word[i]-'a']-prev);
            prev =  mp[word[i]-'a'];
        }
        return totalTime;
    }
};