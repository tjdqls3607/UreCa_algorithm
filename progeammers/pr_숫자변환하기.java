package progeammers;

class Solution {
    public int solution(int x, int y, int n) {
        int dp[] = new int[y+1];
        for (int i=x; i<=y; i++) {  // 값이 안나올때 -1
            if(i!=x && dp[i] == 0) {
                dp[i] = -1;
                continue;

            }
            if(i+n <= y) {  // x+n 일때
                dp[i+n] = (dp[i+n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i+n]);
            }
            if (i*2 <= y) { // x*2 일때
                dp [i*2] = (dp[i*2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i*2]);
            }
            if (i*3 <= y) {
                dp [i*3] = (dp[i*3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i*3]);
            }
        }
        return dp[y];
    }
}

