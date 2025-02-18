package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_로봇청소기 {
    static int N, M,
            r, c, d, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 둘째줄
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();
        System.out.println(ans);


    }
    static void clean() {
        while (true) {
            if (!visit[r][c]) { // 현재 위치 청소
                visit[r][c] = true;
                ans++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;   // 반시계 방향 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M &&
                        map[nx][ny] == 0 && !visit[nx][ny] ) {  // 범위 확인
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if ( !moved ) {
                int bx = r - dx[d];
                int by = c - dy[d];

                if (bx >= 0 && by >= 0 && bx < N && by < M &&
                       map[bx][by] == 0) {    // 움직일수 있는 범위 내
                    r = bx;
                    c = by;
                }else {
                    break;
                }
            }
        }
    }
}
