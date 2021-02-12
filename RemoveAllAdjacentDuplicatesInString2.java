/* Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique. */

class Pair {
    char ele;
    int count;
    Pair(char ele,int count) {
        this.ele = ele;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            
            if(!dq.isEmpty() && dq.peek().ele == s.charAt(i) && dq.peek().count+1==k) {
                while(!dq.isEmpty() && dq.peek().ele == s.charAt(i))
                    dq.pop();
                  
            }
            else {
                Pair p ;
                if(!dq.isEmpty() && dq.peek().ele == s.charAt(i))
                    p = new Pair(s.charAt(i),dq.peek().count+1);
                else
                    p = new Pair(s.charAt(i),1);
                dq.push(p);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!dq.isEmpty()) {
            res.append(dq.pop().ele);
        }
        res.reverse();
        return res.toString();
    }
}