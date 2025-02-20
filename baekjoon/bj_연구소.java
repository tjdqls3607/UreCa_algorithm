package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_연구소 {
    static int N,M, ans; // 지도의 세로 크기 N, 가로 크기 M
    static int[][] map; // 연구소 지도
    static boolean[][] visit;   // 바이러스가 방문한 위치
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {       // 연구소 맵을 그려보자
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {      // 연구소의 좌표에 값이 2가 있으면 바이러스가 있음
                    list.add(new int[]{i, j});
                }
            }
        }
        //  빈 공간에서 벽을 세울 수 있는 모든 조합을 생성
        comb(0,0);
        System.out.println(ans);

    }

    static void comb (int idx, int count) {   // 벽을 세울 수 있는 조합을 만들자
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            int[] cur = list.get(i);
            int x = cur[0], y=cur[1];

            if (map[x][y] == 0) {   // 만약 연구소 지도에 접근할수 있는 위치면
                map[x][y] = 1;  // 벽을 세울 수 있다/
                comb(i+1, count+1); // 다음 위치로 이동함
                map[x][y] = 0;  // 벽을 세운 위치를 다시 비움

            }
        }
    }

    static void bfs() {    // 바이러스가 퍼지기 위해 넓이우선 탐색
        visit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {   //4방 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx>=0 && nx < N && ny>=0 && ny < M &&
                        !visit[nx][ny] && map[nx][ny]==0) { // 주어진 범위 내에 방문한 적 없으면
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;

                }
            }
        }

        int safeZone = 0;   // 안전한 곳 계산하기
        for (int i = 0; i < N; i++) {   // 맵 다 돌아보고
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    safeZone++;
                }
            }
        }

        ans = Math.max(ans, safeZone);
    }
}
