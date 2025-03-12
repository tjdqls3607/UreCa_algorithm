package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_점프 {
    static int N, ans;   // 판의 크기, 정답
    static int[][] dp;    // dp 배열
    static int[][] map; // 게임판
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 배열 크기 입력
        map = new int[N][N];
        dp = new int[N][N];
        ans = 0;
        for (int i = 0; i < N; i++) {       // 이건 배열에 수 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dp[0][0] = 1;   // 시작 위치

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==N-1 && j==N-1) continue;

                int jumps = map[i][j];  // 점프 하는 거리

                if (jumps == 0) continue;   // 점프 할 수 없는 칸은 건너뜀

                if (i+jumps < N) dp[i+jumps][j] += dp[i][j];    // 아래로 점프
                if (j+jumps < N) dp[i][j+jumps] += dp[i][j];    // 오른쪽으로 점프
            }

        }

        System.out.println(dp[N-1][N-1]);


    }
}
