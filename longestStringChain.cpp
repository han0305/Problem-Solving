/* Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words. */

bool compFunc(string s1,string s2) {
    
    return s1.length()<s2.length();
}
class Solution {
public:
    
    int longestStrChain(vector<string>& words) {
        
        int l = words.size();
        if(l == 0) 
            return 0;
        sort(words.begin(),words.end(),compFunc);
       unordered_map<string,int> umap;
        int maxm = INT_MIN;
        for(int i=0;i<l;i++) {
            for(int j=0;j<words[i].length();j++) {
                string sub = words[i].substr(0,j) + words[i].substr(j+1);
                
                    umap[words[i]] = max(umap[words[i]],1+umap[sub]);
                
            }
            maxm = max(umap[words[i]],maxm);
        }
        return maxm;
    
    }
};