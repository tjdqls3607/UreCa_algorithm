package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 현재 아기상어 자리에서 반복적으로 최단경로의 물고기를 잡으러ㅗ 가는 행위 반복 <= bfs
// 몇 초동안 계속 물고기를 먹을 수 있는지 <= 계속 물고기를 먹는 동안 이동한 거리 <= bfs()  수행마다 걸린 시간 (거리)
public class bj_아기상어2 {
    static int N, sy, sx, sSize, sEatCnt, ans;
    static int[][] map;

    //bfs
    static Queue<Node> q = new ArrayDeque<>();
    static boolean[][] visit;
    // delta
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 9) {
                    sy = i;
                    sx = j;
                }

                map[i][j] = n;
            }
        }
        // 시뮬레이션
        sSize = 2;

        // 반복횟수 미정 <= while
        while (true) {
            // 최단거리 물고기를 먹는 과정에서 이동한 거리 return, 못 먹으면 0 리턴
            int cnt = bfs();
            if (cnt == 0) break;
            ans += cnt;
        }

        System.out.println(ans);
    }

    // 최단거리의 물고기를 먹으려고 시도
    // 성공 : 이동한 거리(시간)
    // 실패 : 0 리턴
    static int bfs() {
        return 1;
    }

    static class Node {
        int x, y, d;    // d거리
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
