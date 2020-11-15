/* You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb! */

class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        int l = code.size();
        int rev = k>0?false:true;
        vector<int> res;
        for(int i=0;i<l;i++) {
            int sum = 0;
            int count = 0;
            if(rev == true) {
                int j = i-1;
                while(count<abs(k)) {
                    sum+=code[(j+l)%l];
                    j--;
                    count++;
                }
                res.push_back(sum);
            }
            else {
                int j = i+1;
                while(count<k) {
                    sum+=code[(j+l)%l];
                    j++;
                    count++;
                }
                res.push_back(sum);
            }
            
        }
        return res;
    }
};