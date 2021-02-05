/* You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.

Return the maximum number of apples you can put in the basket. */

class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
            if(sum>5000)
                break;
            count++;
        }
        return count;
    }
}