/* There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams). */

class Solution {
public:
    int max(int a,int b) {
        
        return a >= b ? a : b;
        
    }
    int numTeams(vector<int>& rating) {
        int incComb = 0;
        int decComb = 0;
        for(int i=1;i<rating.size();i++) {
             int lcount = 0;
             int rcount = 0;
            int left = i-1;
            while(left>=0) {
                if(rating[left]<rating[i]) {
                    lcount++;
                }
                left--;
            }
            int right = i+1;
            while(right<rating.size()) {
                if(rating[right]>rating[i]) {
                    rcount++;
                }
                right++;
            }
            incComb += lcount*rcount;
        }
        
        for(int i=1;i<rating.size();i++) {
             int lcount = 0;
             int rcount = 0;
            int left = i-1;
            while(left>=0) {
                if(rating[left]>rating[i]) {
                    lcount++;
                }
                left--;
            }
            int right = i+1;
            while(right<rating.size()) {
                if(rating[right]<rating[i]) {
                    rcount++;
                }
                right++;
            }
            decComb += lcount * rcount;
        }
     return incComb + decComb;   
    }
};