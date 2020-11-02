/* Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet. */

class Solution {
public:
    int countVowelStrings(int n) {
        if(n==1) {
            return 5;
        }
        vector<int> freq = {5,4,3,2,1};
        int total = 15;
        while(n>2) {
           int currTotal = 0;
           for(int i=0;i<5;i++) {
               int temp = freq[i];
               freq[i] = total;
               currTotal+=total;
               total-=temp;
               
           }
            total = currTotal;
            n--;
        }
        
        return total;
    }
};