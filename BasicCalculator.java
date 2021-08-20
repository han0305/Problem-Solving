/* Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval(). */

class Pair {
    
    int index;
    int result;
    Pair(int result, int index) {
        this.result = result;
        this.index = index;
    }
}

class Solution {
    Pair eval(String s, int idx) {
        int currSign = 1;
        int currNo = 0;
        int i = idx;
        int res = 0;
        while(i<s.length()) {
            
            char curr = s.charAt(i);
            if(curr == ' ') {
                i++;
                continue;
            }
            if(curr == '(') {
                Pair p = eval(s,i+1);
                res+=currSign*p.result;
                i=p.index+1;
            }
            else if(curr == ')') {
                Pair p = new Pair(res+currSign*currNo,i);
                return p;
            }
            else if(curr == '+') {
                res+=currSign*currNo;
                currSign=1;
                currNo=0;
                i++;
            }
            else if(curr == '-') {
                res+=currSign*currNo;
                currSign=-1;
                currNo=0;
                i++;
            }
            else {
                currNo = currNo*10+(curr-'0');
                i++;
            }
        }
        
        if(currNo>0) {
            res+=currSign*currNo;
        }
        return new Pair(res,s.length());
        
        
    }
    public int calculate(String s) {
        return eval(s,0).result;
    }
}