package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_파이프 {
    static int N, ans;   // 집의 크기, 정답
    static int[][] map; // 집 꼬라지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for (int i = 0; i < N; i++) {   // 집이 어떻게 생겼을까
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(ans);


    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 1, 0}); // 처음 시작 {0 : 가로, 1 : 세로, 0 : 대각선}

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dir = cur[2];

            if (x == N - 1 && y == N - 1) { // 끝에 도착하면 답을 증가 (배열이기 때문에 N값에서 -1 함)
                ans++;
                continue;
            }

            if (dir == 0 || dir == 2) { // 가로로 이동 ( 방향이 가로 혹은 대각선 일때)
                int nx = x, ny = y + 1; // 오른쪽으로 이동하자
                if (isValid(nx,ny)) {
                    queue.offer(new int[]{nx, ny, 0});
                }
            }

            if (dir == 1 || dir == 2) { // 세로로 이동   (방향이 세로 혹은 대각선 일때)
                int nx = x + 1, ny = y; // 아래로 이동하자
                if (isValid(nx,ny)) {
                    queue.offer(new int[]{nx, ny, 1});
                }
            }

            int nx = x + 1, ny = y + 1; // 대각선 이동   ( 오른쪽 아래로 향해 있음)
            if (isValid(nx,ny) && isValid(x, y+1) && isValid(x+1, y)) {
                // 대각선 파이프는 배열의 3칸을 차지하기 때문에
                queue.offer(new int[]{nx, ny, 2});
            }
        }
    }

    static boolean isValid(int x, int y) {  // 범위 체크하고 이동 가능한지 본다
        return x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 0;
    }
}
