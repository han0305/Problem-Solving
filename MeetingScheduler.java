/* Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.  

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1. */

class CustomSort implements Comparator<int[]> {
    
    @Override
    public int compare(int[] a1,int[] a2) {
        return a1[1]-a2[1];
    }
    
    
} 

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        Arrays.sort(slots1,new CustomSort());
        Arrays.sort(slots2,new CustomSort());
        int n1 = slots1.length;
        int n2 = slots2.length;
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2) {
            if(slots2[j][1] >= slots1[i][0] && slots2[j][1]  <= slots1[i][1]) {
                int start = Math.max(slots1[i][0],slots2[j][0]);
                if(start+duration<=slots2[j][1]){
                    res.add(start);
                    res.add(start+duration);
                    break;
                }
                j++;
            }
            else if(slots1[i][1] >= slots2[j][0] && slots1[i][1]  <= slots2[j][1]) {
                int start = Math.max(slots1[i][0],slots2[j][0]);
                if(start+duration<=slots1[i][1]){
                    res.add(start);
                    res.add(start+duration);
                    break;
                }
                i++;
            }
            else if(slots1[i][1]<slots2[j][0]) {
                i++;
            }
            else
                j++;
            
            
        }
        
        return res;
    }
}