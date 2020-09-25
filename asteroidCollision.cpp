/* We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet. */

class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        int l = asteroids.size();
        stack<int> st;
        vector<int> res;
        
        for(int i=0;i<l;i++) {
            int curr = asteroids[i];
            bool noPush = false;
            
            while(!st.empty() && curr<0 && st.top()>=0 ){
                if(curr<0 && st.top()>=0 && abs(curr) == abs(st.top())) {
                    st.pop();
                    noPush = true;
                    break;
                }
                else if(abs(curr) < abs(st.top())) {
                 curr = st.top();
                }
                st.pop();   
            }
            if(!noPush)
            st.push(curr);
            
        }
        while(!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }
        reverse(res.begin(),res.end());
        return res;
    }
};