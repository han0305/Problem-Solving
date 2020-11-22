/* Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string. */

class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        
        int l1 = word1.size();
        int l2 = word2.size();
        
        int i = 0;
        int j = 0;
        int curr1 = 0;
        int curr2 = 0;
        while(i<l1 && j<l2) {
            
            if(curr1<word1[i].length() && curr2<word2[j].length()) {
                if(word1[i][curr1] != word2[j][curr2])
                    break;
                curr1++;
                curr2++;
            }
            if(curr1==word1[i].length()) {
                i++;
                curr1 = 0;
            }
            if(curr2==word2[j].length()) {
                j++;
                curr2 = 0;
            }
        }
        
        return (i == l1) && (j == l2);
    }
};