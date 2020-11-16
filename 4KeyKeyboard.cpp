/* Imagine you have a special keyboard with the following keys:

Key 1: (A): Print one 'A' on screen.

Key 2: (Ctrl-A): Select the whole screen.

Key 3: (Ctrl-C): Copy selection to buffer.

Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen. */

class Solution {
public:
    int maxA(int N) {
        vector<int> dp(N+1,0);
        for(int i=1;i<=N;i++) {
            if(i<=4) {
                dp[i] = i;
            }
            else {
                dp[i] = dp[i-1] + 1;
                for(int j = i-2;j>=3;j--){
                    if(i-(j+2)>0){
                        dp[i] = max(dp[i],dp[j] + (i-(j+2))*dp[j]);
                    }
                }
            }
        }
        return dp[N];
    }
};