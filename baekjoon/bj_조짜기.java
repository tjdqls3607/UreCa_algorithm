package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_조짜기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String Numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(Numbers, " ");

        int score[] = new int[n+1];
        int dp[] = new int[n+1];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, Math.abs(score[j] - score[i]) + dp[j-1]);
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);
    }
}
