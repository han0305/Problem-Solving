/* Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings. */

class CustomComp implements Comparator<int[]> {
    
    public int compare(int[] a,int[] b) {
        
        if(a[0] < b[0]) {
            return -1;
        }
        else if(b[0]<a[0]) {
            return 1;
        }
        return a[1]-b[1];
    }
    
}

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals,new CustomComp());
        
        boolean isPossible = true;
        for(int i=1;i<m;i++) {
            if(intervals[i][0] < intervals[i-1][1]) {
                isPossible = false;
                break;
            }
        }
        
        return isPossible;
    }
}