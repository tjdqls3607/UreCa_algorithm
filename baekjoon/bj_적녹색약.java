package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_적녹색약 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[N][N];
        int color = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs (i,j, map[i][j], false);
                    color++;
                }
            }
        }

        visited = new boolean[N][N];
        int color_blinds = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j], true);
                    color_blinds++;
                }
            }
        }

        System.out.print(color+ " " + color_blinds);
    }
    static void bfs(int x, int y, char color, boolean blind) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (blind) {    // 전재준 계산
                        if ((color == 'R' || color == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }else if (color == 'B' && map[nx][ny] == 'B') {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }else { // 일반인 계산
                        if (map[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }

                    }
                }
            }

        }
    }
}
