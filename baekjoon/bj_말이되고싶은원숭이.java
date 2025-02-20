package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_말이되고싶은원숭이 {
        static int K, ans;   // 원숭이가 말처럼 움직일수 있는 횟수, 동작수의 최소값
        static int W,H; // 가로길이, 세로길이
        static boolean[][][] visit;   // 방문한 곳은 중복으로 못가 그리고 말처럼 이동한 것도 생각
        static int[][] map;    // 입력받을 배열(동물원)
        static int[] dx = { -1, 0, 1, 0 };  // 사방탐색
        static int[] dy = { 0, -1, 0, 1 };  // 사방탐색
        static int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
        static int[] horseDy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        K = Integer.parseInt(st.nextToken());    // 원숭이가 말처럼 몇번 움직일 건지

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());   //가로길이
        H = Integer.parseInt(st.nextToken());   //세로길이

        map = new int[H][W];
        visit = new boolean[H][W][K+1];  // 방문했던 곳은 중복이라서 여기에

        for (int i = 0; i < H; i++) {   // map 에 배열의 요소를 입력하자
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int result = bfs(0,0);
        System.out.println(result);
    }

    static int bfs (int x, int y) {  //
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y,0,0});
        visit[x][y][0] = true;



        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0], nowY = now[1], nowK = now[2], moves = now[3];

            if (nowX == H -1 && nowY == W - 1) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {   // 4방탐색
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >=0 && ny >=0 && nx < H && ny < W && map[nx][ny] == 0) {
                    if (!visit[nx][ny][nowK] ) {  // 방문한 좌표가 아니고 map의 미래경로에 1이 있다면
                        queue.offer(new int[]{nx, ny, nowK, moves + 1});
                        visit[nx][ny][nowK] = true;   // 방문 처리함
                    }
                }
            }

            // 말 처럼 이동 (K번 남아있을때 가능함)
            if (nowK < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = nowX + horseDx[i];
                    int ny = nowY + horseDy[i];

                    if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0) {
                        if (!visit[nx][ny][nowK+1]) {
                            queue.offer(new int[]{nx, ny, nowK+1, moves + 1});
                            visit[nx][ny][nowK+1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
