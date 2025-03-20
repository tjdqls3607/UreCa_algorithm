package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_평범한배낭 {
    static int N, K, W, V;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            for (int j = K; j >= W; j--) {    // 0/1 배낭 문제에서는 뒤에서부터 업데이트 (무게 초과 방지)
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }


        System.out.println(dp[K]);
    }
}
