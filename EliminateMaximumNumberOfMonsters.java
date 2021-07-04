/* You are playing a video game where you are defending your city from a group of n monsters. You are given a 0-indexed integer array dist of size n, where dist[i] is the initial distance in meters of the ith monster from the city.

The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n, where speed[i] is the speed of the ith monster in meters per minute.

The monsters start moving at minute 0. You have a weapon that you can choose to use at the start of every minute, including minute 0. You cannot use the weapon in the middle of a minute. The weapon can eliminate any monster that is still alive. You lose when any monster reaches your city. If a monster reaches the city exactly at the start of a minute, it counts as a loss, and the game ends before you can use your weapon in that minute.

Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city. */

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
     
        double[] time = new double[dist.length];
        for(int i=0;i<dist.length;i++) {
            time[i] = (dist[i]*1.0)/speed[i];
        }
        Arrays.sort(time);
        int count = 1;
        for(int i=1;i<time.length;i++) {
            if(time[i]<=i) {
                break;
            }
            count++;
        }
        return count;
    }
}