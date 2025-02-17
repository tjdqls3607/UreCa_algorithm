package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_알파벳 {

    static int R, C, maxCount = 0;   // 행 크기, 열 크기, 최대 이동 거리
    static char[][] map; // 문자형 배열 선언
    static boolean[] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   // 행 입력 받기
        C = Integer.parseInt(st.nextToken());   // 열 입력 받기
        map = new char[R][C];   //배열 생성

        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();  // ✅ 한 줄을 통째로 읽기
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j); // ✅ 한 글자씩 저장
            }
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0,0,1);

        System.out.println(maxCount);
    }


   static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {   // 4방 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (! visited[map[nx][ny] - 'A']) {
                    visited[map[nx][ny] - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    visited[map[nx][ny] - 'A'] = false;
                }
            }
        }
   }
}
