/* Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays. */

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        int i,j,k;
        i=j=k=0;
        List<Integer> res = new ArrayList<>();
        while(i<arr1.length && j<arr2.length && k<arr3.length) {
            
            if(arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                res.add(arr1[i]);
                i++;
                j++;
                k++;
                continue;
            }
            int maxm = Math.max(arr1[i],Math.max(arr2[j],arr3[k]));
            if(arr1[i]<maxm)
                i++;
            if(arr2[j]<maxm)
                j++;
            if(arr3[k]<maxm)
                k++;
        }
        return res;
    }
}