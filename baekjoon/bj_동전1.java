package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_동전1 {
    static int n,k; // 동전의 가지수, 목표 가치
    static int[] dp;
    static int[] coins; // 동전의 종류
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k+1];  // 목표금액까지 이기 때문에 k 사용
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;  // 0원을 만드는 방법

        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);

    }
}
