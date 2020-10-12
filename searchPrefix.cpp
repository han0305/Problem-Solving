/* Given a sentence that consists of some words separated by a single space, and a searchWord.

You have to check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).

If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.

A prefix of a string S is any leading contiguous substring of S. */

class Solution {
public:
    
    bool isPrefix(string word,string prefix) {
        int l1 = word.length();
        int l2 = prefix.length();
        int i = 0;
        int j = 0;
        while(i<l1 && j<l2) {
            
            if(word[i]!=prefix[j])
                break;
            i++;
            j++;
        }
        return j == l2; 
        
    }
    
    int isPrefixOfWord(string sentence, string prefix) {
       
        int l = sentence.length();
        string word = "";
        int wordCount = 0;
        for(int i=0;i<l;i++) {
           
            if(i==l-1) {
                wordCount++;
                word = word + string(1,sentence[i]);
                if(isPrefix(word,prefix)) {
                    return wordCount;
                }
            }
            else if(sentence[i] == ' ') {
                 wordCount++;
                if(isPrefix(word,prefix)) {
                    return  wordCount;
                }
                word = "";
            }
            else {
                word = word+string(1,sentence[i]);
            }
        }
        
        return -1;
    }
};