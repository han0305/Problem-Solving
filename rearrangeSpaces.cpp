/* You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces. */

class Solution {
public:
    string reorderSpaces(string text) {
        int l = text.length();
        vector<string> s;
        int spaceCount = 0;
        string temp="";
        for(int i=0;i<l;i++) {
            if(text[i] == ' ') {
                spaceCount++;
                if(temp!="") {
                    s.push_back(temp);
                    temp = "";
                }
            }
            else {
                temp = temp+string(1,text[i]);
                if(i==l-1) {
                    s.push_back(temp);
                }
                    
            }
        }
        if(spaceCount == 0) {
            return text;
        }
        int wordsCount = s.size();
        if(wordsCount == 1) {
            return s[0]+string(spaceCount,' ');
        }
        int spaces = spaceCount/(wordsCount-1);
        int endSpaces = spaceCount%(wordsCount-1);
        string res="";
        string midSpace = string(spaces,' ');
        string endSpace = string(endSpaces,' ');
            
        for(int i=0;i<wordsCount;i++) {
           if(i == wordsCount-1) {
               res = res+s[i]+endSpace;
               break;
           }
           res =res+ s[i]+midSpace;    
        }
        
        return res;
    }
};