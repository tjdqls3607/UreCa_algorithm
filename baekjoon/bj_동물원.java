package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_동물원 {
    static int N;
    static int dp[];
    static final int MOD = 9901; // 나머지 연산 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];


        dp[1] = 3;  // 왼쪽 사자, 오른쪽 사자, 사자 없음

        if (N > 1) {
            dp[2] = 7;  // 두 번째 줄의 경우의 수
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}
