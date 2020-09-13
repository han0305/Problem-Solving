/* You are given a list of preferences for n friends, where n is always even.

For each person i, preferences[i] contains a list of friends sorted in the order of preference. In other words, a friend earlier in the list is more preferred than a friend later in the list. Friends in each list are denoted by integers from 0 to n-1.

All the friends are divided into pairs. The pairings are given in a list pairs, where pairs[i] = [xi, yi] denotes xi is paired with yi and yi is paired with xi.

However, this pairing may cause some of the friends to be unhappy. A friend x is unhappy if x is paired with y and there exists a friend u who is paired with v but:

x prefers u over y, and
u prefers x over v.
Return the number of unhappy friends.   */

class Solution {
public:
    
    bool isCompatible(vector<vector<int>> preferences,int i,unordered_map<int,int> p,int j) {
           
        int pt = p[i];
        vector<int> pref = preferences[i];
        int n = pref.size();
        bool flag = false;
        for(int k = 0;k<n;k++) {
            if(pref[k] == j) {
                flag = true;
                break;
            }
            if(pref[k] == pt) {
                flag = false;
                break;
            }
        }
        
        
        return flag;
        
        
    }
    
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        int count = 0;
       // unordered_map<int,int> v;
        unordered_map<int,int> p;
        int pl = pairs.size();
        for(int i=0;i<pl;i++) {
            p[pairs[i][0]] = pairs[i][1];
            p[pairs[i][1]] = pairs[i][0];
        }
        for(int i=0;i<n;i++) {
            vector<int> pref = preferences[i];
            int n = pref.size();
            int pt = p[i];
            //if(v.find(i) != v.end()) 
              //  continue;
            for(int j=0;j<n;j++) {
                
                if(pref[j] == pt ){ 
                    
                    break;
                }
                if(isCompatible(preferences,pref[j],p,i)) {
                    
                //    v[pref[j]] = 1;
                    count++;
                    break;
                }
           
            }
        }
        return count;
    }
};