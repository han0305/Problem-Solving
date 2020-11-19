/* Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed. */

class Solution {
public:
    int maxNumberOfBalloons(string s) {
        unordered_map<char,int> freq;
        int l = s.length();
        for(int i=0;i<l;i++) {
            if(s[i] == 'b' || s[i] == 'a' || s[i] == 'l' || s[i] == 'o' || s[i] == 'n')
                freq[s[i]]++;
        }
        
        int maxm = INT_MAX;
        if(freq.size()!=5){
            return 0;
        }
        for(auto i:freq) {
            if(i.first == 'l' || i.first == 'o') {
                maxm = min(maxm,i.second/2);
            }
            else {
                maxm = min(maxm,i.second);
            }
        }
        return maxm;
    }
};