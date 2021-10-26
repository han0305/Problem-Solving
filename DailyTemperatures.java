/* Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead. */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        st.push(0);
        for(int i=1;i<temperatures.length;i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}