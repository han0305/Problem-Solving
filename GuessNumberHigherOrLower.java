/* We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns 3 possible results:

-1: The number I picked is lower than your guess (i.e. pick < num).
1: The number I picked is higher than your guess (i.e. pick > num).
0: The number I picked is equal to your guess (i.e. pick == num).
Return the number that I picked. */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int numberPicked = 0;
        while(start<=end) {
            int guessedNumber = (start+(end-start)/2);
            int guessResult = guess(guessedNumber);
            if(guessResult == 0) {
                numberPicked = guessedNumber;
                break;
            } else if(guessResult == 1) {
                start = guessedNumber+1;
            } else {
                end = guessedNumber-1;
            }
        }
        
        return numberPicked;
    }
}