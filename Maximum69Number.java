/* Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6). */

class Solution {
    public int maximum69Number (int num) {
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        while(num>0) {
            
            al.add(num%10);
            num=num/10;
        }
        
        int res = 0;
        int count = 0;
        for(int i=al.size()-1;i>=0;i--) {
            
            if(count==0 && al.get(i)==6) {
                
                res=res*10+9;
                count++;
            }
            else {
                
                res=res*10+al.get(i);
            }
            
        }
        
        return res;
    }
}