package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_단지번호붙이기 {
    static boolean[][] N;   // 총 아파트 크기의 배열
    static int n;   // 아파트의 가로 세로 길이 ( 정사각형이 되어야함 )
    static boolean[][] visit;

    // 상 - 하 - 좌 - 우 순서
    static int[] dy = { -1, 1,  0, 0 };
    static int[] dx = {  0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 아파트의 가로세로 길이를 입력 받고
        N = new boolean[n][n];  // 그만큼 아파트의 총 크기를 선언
        visit = new boolean[n][n];


        dfs(1, 1);

    }

    static void dfs (int x, int y) {
        visit[x][y] = true;
        System.out.println(N[x][y] + " ");

        for (int d = 0; d < n; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 1 || nx < 1 || ny >= n || nx >= n || visit[ny][nx])
                continue;

            dfs(ny, nx);
        }
    }
}
