/* There are n projects numbered from 0 to n - 1. You are given an integer array milestones where each milestones[i] denotes the number of milestones the ith project has.

You can work on the projects following these two rules:

Every week, you will finish exactly one milestone of one project. You must work every week.
You cannot work on two milestones from the same project for two consecutive weeks.
Once all the milestones of all the projects are finished, or if the only milestones that you can work on will cause you to violate the above rules, you will stop working. Note that you may not be able to finish every project's milestones due to these constraints.

Return the maximum number of weeks you would be able to work on the projects without violating the rules mentioned above. */

class Solution {
    public long numberOfWeeks(int[] milestones) {
        if(milestones.length == 1) {
            return 1;
        }
        int maxm = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<milestones.length;i++) {
            maxm = Math.max(maxm,milestones[i]);
        }
        int temp = maxm;
        long res = 0;
        boolean isStart = true;
        for(int i=0;i<milestones.length;i++) {
            if(milestones[i] == maxm && count == 0) {
                count = 1;
                continue;
            }
            if(temp == 0) {
                res+=milestones[i];
            }
            else if(milestones[i] > temp) {
                res = res + 2*temp+1+(milestones[i]-temp-1);
                temp = 0;
            }
            else {
                if(isStart) {
                    res = res+2*milestones[i]+1;
                    temp = temp-(milestones[i]+1);
                    isStart = false;
                }
                else {
                    res = res+2*milestones[i];
                    temp = temp-(milestones[i]);
                }
                
            }
        }
        return res;
    }
}