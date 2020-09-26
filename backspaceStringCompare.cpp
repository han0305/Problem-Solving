/* Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty. */

class Solution {
public:
    bool backspaceCompare(string S, string T) {
        
        int ls = S.length();
        int lt = T.length();
        
        stack<char> s1,s2;
        for(int i=0;i<ls;i++) {
            if(S[i] == '#' && !s1.empty()) {
                s1.pop();
            }
            else if(S[i]!='#')
                s1.push(S[i]);
        }
        
        for(int i=0;i<lt;i++) {
            if(T[i] == '#' && !s2.empty()) {
                s2.pop();
            }
            else if(T[i]!='#')
                s2.push(T[i]);
        }
       
        bool isSame = true;
        while(!s1.empty() && !s2.empty()) {
            
            if(s1.top()!=s2.top()) {
                isSame = false;
                break;
            }
            s1.pop();
            s2.pop();
            
        }
        if(isSame == false) 
            return false;
        if(!s1.empty() || !s2.empty()) {
            return false;
        }
        
        return true;
        
    }
};