/* A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times. */

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = 0;
        int curr = 0;
        int l = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<answerKey.length();i++) {
            if(answerKey.charAt(i) == 'F') {
                curr++;
                q.offer(i);
            }
            if(curr > k) {
                curr--;
                l = q.poll()+1;
            }
            maxT = Math.max(maxT,i-l+1);
        }
        int maxF = 0;
        curr = 0;
        l = 0;
        q = new ArrayDeque<>();
        for(int i=0;i<answerKey.length();i++) {
            if(answerKey.charAt(i) == 'T') {
                curr++;
                q.offer(i);
            }
            if(curr > k) {
                curr--;
               l = q.poll()+1;
            }
            maxF = Math.max(maxF,i-l+1);
        }
        return Math.max(maxT,maxF);
    }
}