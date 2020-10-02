/* Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1. */

class Solution {
public:
    void swap(char* a,char* b) {
        
        char temp = *a;
        *a = *b;
        *b = temp;
    }
    
    
    
    int nextGreaterElement(int n) {
        string no;
        while(n>0) {
            int last = n%10;
            n = n/10;
            no = to_string(last)+no;
        }
        int last=no.length()-1;
        while(last>0 && no[last] <= no[last-1])   {
            last--;
        }
        if(last == 0) {
            return -1;
        }
        int i = last;
        while(no[last-1]<no[i]) {
            i++;
        }
        swap(&no[last-1],&no[i-1]);
        reverse(no.begin()+last,no.end());
        long res = stol(no);
       
        return res > INT_MAX ? -1:res;
    }
};