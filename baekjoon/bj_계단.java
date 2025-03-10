package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_계단 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());   // 계단의 개수
        int[] m = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            m[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(m[1]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = m[1];  // 시작 계단
        dp[2] = m[1] + m[2];

        for (int i = 3; i <= n; i++) {
           dp[i] = Math.max(dp[i - 2], dp[i - 3] + m[i - 1]) + m[i] ;
        }
        System.out.println(dp[n]);

    }
}
