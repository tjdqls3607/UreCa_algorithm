package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_아기상어 {
    static int N; // 공간의 크기
    static int[][] sea = new int[N][N];
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    // 상어의 위치 , 상어의 기본 크기, 먹은 횟수, 총 시간
    static int sharkX, sharkY, sharkSize = 2, eatCount = 0, totalTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 입력 1번째 줄 배열의 크기 입력
        sea = new int[N][N];

        // 배열의 요소 입력
        for (int i = 0; i < sea.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sea[i].length; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    sea[i][j] = 0;
                }
            }
        }

        while (true) {
            int time = bfs();
            if (time == -1) break;  // 더 이상 먹을 물고기가 없으면 종료
            totalTime += time;
        }


        System.out.println(totalTime);


    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[2] == b[2]) {  // 거리가 같으면
                if(a[0]== b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });

        visited = new boolean[N][N];
        q.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0], y = current[1], distance = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && ! visited [nx][ny] && sea[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, distance + 1});

                    if (sea[nx][ny] > 0 && sea[nx][ny] < sharkSize) {
                        pq.offer(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }
        if (!pq.isEmpty()) {
            int[] target = pq.poll();
            sharkX = target[0];
            sharkY = target[1];
            sea[sharkX][sharkY] = 0;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
            return target[2];
        }
        return -1;
    }
}
