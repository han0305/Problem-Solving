/* A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string "". */

class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        priority_queue<pair<int,char>> pq;
        if(a>0) 
            pq.push(make_pair(a,'a'));
        if(b>0) 
            pq.push(make_pair(b,'b'));
        if(c>0)
            pq.push(make_pair(c,'c'));
        string res = "";
        int len = 0;
        while(!pq.empty()) {
            
            pair<int,char> max1 = pq.top();
            pq.pop();
            if(!pq.empty()) {
                pair<int,char> max2 = pq.top();
                pq.pop();
                if(len>=2 && res[len-1] == max1.second && res[len-2] == max1.second) {
                    res = res + string(1,max2.second);
                    max2.first--;
                    len++;
                }
                else {
                    res = res + string(1,max1.second);
                    max1.first--;
                    len++;
                }
                if(max1.first>0)
                    pq.push(max1);
                if(max2.first>0) 
                    pq.push(max2);
                
            }
            else {
                if(len>=2 && res[len-1] == max1.second && res[len-2] == max1.second)
                    break;
                else {
                    res = res + string(1,max1.second);
                    max1.first--; 
                    len++;
                }
                if(max1.first>0)
                    pq.push(max1);
            }
            
            
        }
        return res;
    }
};