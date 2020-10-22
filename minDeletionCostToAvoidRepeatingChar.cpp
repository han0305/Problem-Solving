/* Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.

Return the minimum cost of deletions such that there are no two identical letters next to each other.

Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change. */

class Solution {
public:
    int minCost(string s, vector<int>& cost) {
        
        int  l = s.length();
        if(l<2) {
            return 0;
        }
        int max = cost[0];
        int sum = 0;
        int totalSum = 0;
        for(int i = 1;i<l;i++) {
            if(s[i] == s[i-1]) {
                if(cost[i]>max) {
                    sum+=max;
                    max = cost[i];
                }
                else {
                    sum+=cost[i];
                }
            }
            else {
                totalSum+=sum;
                sum = 0;
                max= cost[i];
            }
            if(i == l-1)
            totalSum+=sum;
        }
        return totalSum;
    }
};