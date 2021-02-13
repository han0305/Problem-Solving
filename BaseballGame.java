/* You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:

An integer x - Record a new score of x.
"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
Return the sum of all the scores on the record. */

class Solution {
    public int calPoints(String[] ops) {
        
        int[] scores = new int[ops.length];
        int sum = 0;
        int j = 0;
        for(int i=0;i<ops.length;i++) {
            
            if(ops[i].equals("+")) {
                int currScore = scores[j-1]+scores[j-2];
                sum+=currScore;
                scores[j++] = currScore;
            }
            else if(ops[i].equals("D")) {
                int currScore = 2*scores[j-1];
                sum+=currScore;
                scores[j++] = currScore;
            }
            else if(ops[i].equals("C")) {
                sum-=scores[j-1];
                j--;
            }
            else {
                int currScore = Integer.parseInt(ops[i]);
                sum+=currScore;
                scores[j++] = currScore;
            }
        }
        
        return sum;
    }
}