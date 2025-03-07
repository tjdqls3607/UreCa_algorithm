package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_벽부수고이동하기 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        // 공백 없는 입력 처리 방식 (charAt 사용)
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄 입력 받음
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0'; // '0' 또는 '1'을 숫자로 변환
            }
        }

        int minlength = bfs();

        System.out.println(minlength);


    }
    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y =  cur[1], dist = cur[2], wbreak = cur[3];

            if (x == N - 1 && y == M - 1) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈 칸일때
                if (map[nx][ny] == 0 && !visited[nx][ny][wbreak]) {
                    visited[nx][ny][wbreak] = true;
                    q.offer(new int[]{nx, ny, dist+1, wbreak});
                }

                if(map[nx][ny] == 1 && wbreak == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, dist+1, 1});
                }
            }
        }
        return -1;
    }
}
