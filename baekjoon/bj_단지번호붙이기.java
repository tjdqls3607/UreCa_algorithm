package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_단지번호붙이기 {
    static int[][] N;   // 총 아파트 크기의 배열
    static int n;   // 아파트의 가로 세로 길이 ( 정사각형이 되어야함 )
    static boolean[][] visit;
    static List<Integer> complexSizes = new ArrayList<>();

    // 상 - 하 - 좌 - 우 순서
    static int[] dy = { -1, 1,  0, 0 };
    static int[] dx = {  0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 아파트의 가로세로 길이를 입력 받고
        N = new int[n][n];  // 그만큼 아파트의 총 크기를 선언
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();  // 공백 없이 한 줄로 주어지므로 charAt() 사용
            for (int j = 0; j < n; j++) {
                N[i][j] = line.charAt(j) - '0';
            }
        }

        int complexCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (N[i][j] == 1 && !visit[i][j]) {
                    complexSizes.add(bfs(i,j));
                    complexCount++;
                }
            }
        }
        Collections.sort(complexSizes);
        System.out.println(complexCount);
        for (int size : complexSizes) {
            System.out.println(size);
        }


    }

   static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >=0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny] && N[nx][ny] == 1) {
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                        size++;
                    }
                }
            }
            return size;
        }
}
