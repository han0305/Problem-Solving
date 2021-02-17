/* Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals. */

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(int[] a,int[] b) -> a[0]-b[0]);
        ArrayList<ArrayList<Integer>> merges = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(intervals[0][0]);
        curr.add(intervals[0][1]);
        merges.add(curr);
        for(int i=1;i<intervals.length;i++) {
            int start = merges.get(merges.size()-1).get(0);
            int end = merges.get(merges.size()-1).get(1);
            
            if(start == intervals[i][0] || end >= intervals[i][1]) {
                end = Math.max(end,intervals[i][1]);
                merges.get(merges.size()-1).set(1,end);
            }
            else {
                curr = new ArrayList<>();
                curr.add(intervals[i][0]);
                curr.add(intervals[i][1]);
                merges.add(curr);
            }
            
        }
        
        return merges.size();
    }
}