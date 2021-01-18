/* Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d. */

class Solution {
    private int getTotal(int n) {
        int total = 0;
        while(n>0) {
            total+=(n-1);
            n--;
        }
        return total;
    }
    public int tupleSameProduct(int[] nums) {
        
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int prod = nums[i]*nums[j];
                int currFreq = freq.getOrDefault(prod,0);
                freq.put(prod,currFreq+1);
            }
        }
        int total = 0;
        for(Map.Entry m : freq.entrySet()) {
            //System.out.println(m.getValue());
            int val = (Integer)m.getValue();
            if(val>1){
            int comb = getTotal(val)*8;
            total+=comb;
            }
        }
        
        return total;
    }
}