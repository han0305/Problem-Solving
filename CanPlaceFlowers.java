/* You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule. */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int prev = -2;
        for(int i=0;i<flowerbed.length;i++) {
            if(flowerbed[i] == 0 && i-prev>1) {
                count++;
                prev = i;
            } else if(flowerbed[i] == 1 && i-prev == 1) {
                count--;
                prev = i;
            } else if(flowerbed[i] == 1) {
                prev = i;
            }
        }
        
        return count >= n;
    }
}