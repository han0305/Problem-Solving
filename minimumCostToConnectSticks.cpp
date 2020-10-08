/* You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way. */

class Solution {
public:
    int connectSticks(vector<int>& sticks) {
        priority_queue <int, vector<int>, greater<int>> pq;
        int l = sticks.size();
        if(l==0 || l==1) 
            return 0;
        
        
        for(int i=0;i<l;i++) {
            pq.push(sticks[i]);
        }
        int sum = 0;
        while(pq.size()>1) {
            
            int n1 = pq.top();
            pq.pop();
            int n2 = pq.top();
            pq.pop();
            
            sum+=n1+n2;
            pq.push(n1+n2);
            
        }
        return sum;
    }
};