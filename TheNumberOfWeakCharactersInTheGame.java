/* You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters. */

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int maxm = properties[properties.length-1][1];
        int count = 0;
        for(int i=properties.length-2;i>=0;i--) {
            if(properties[i][1]>maxm) {
                maxm = properties[i][1];
            } else if(maxm > properties[i][1]) {
                count++;
            }
        }
        
        return count;
        
    }
}