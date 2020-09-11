/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.*/

class Solution {
public:
    int getNumber(string s) {
        int l = s.length();
        int no = 0;
        char sign = '+';
        int i=0;
        if(s[0] == '-' || s[0] == '+') {
            sign = s[0];
            i++;
        }
        while(i<l) {
            
            no = no*10 + (s[i]-'0');
            i++;
        }
        
        return sign == '-' ? no*-1:no;
    }

    
    int evaluate(int n1,int n2,string op) {
        int result;
        
            if(op == "+") result = n1 + n2;
                      
            if(op == "-") result = n1-n2;
                      
            if(op == "*") result = n1*n2;
                     
            if(op == "/") result = n1/n2;
                     
        
        
        return result;
    }
    int evalRPN(vector<string>& s) {
          
        int l = s.size();
        stack<int> st;
        
        for(int i=0;i<l;i++) {
            
            
            if(s[i] == "+" || s[i] == "-" || s[i] == "*" || s[i] == "/") {
                int n1 = st.top();
                st.pop();
                int n2 = st.top();
                st.pop();
                st.push(evaluate(n2,n1,s[i]));
                
            }
            else {
                st.push(getNumber(s[i]));
            }
        }
        
        
        return st.top();
    }
};