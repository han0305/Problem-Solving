/* We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero. */

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        
        int n = bits.length;
        if(n==1 && bits[0] == 0)
            return true;
        int j = 0;
        int i = 1;
        for(i = 1;i<bits.length-1;i++) {
            if(i == j && bits[i] == 0) {
                j++;
            }
            else if(i == j) {
                continue;
            }
            else if(bits[j] == 0){
                j = i;
            }
            else {
                j=i+1;
            }
            
        }
        if(j<i && bits[j] == 0 && bits[i] == 0) {
            return true;
        }
        return i == j;
    }
}