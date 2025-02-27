package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_욕심쟁이판다 {
    static int N , cnt;
    static int[][] map, dp; //대나무숲
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N]; // 최대 이동 가능 횟수 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = Math.max(cnt,dfs(i,j));
            }
        }

        System.out.println(cnt);
    }
    static int dfs(int x, int y) {
        if(dp[x][y] != 0){      // 이미 방문한 곳이면 dp 값 반환
            return dp[x][y];
        }
        dp[x][y] = 1;  //최소한 한자리 방문
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && ny>=0 && nx<N && ny<N){    // 범위 체크
                if(map[nx][ny] > map[x][y] ){
                    dp[x][y] =Math.max(dp[x][y], dfs(nx, ny) + 1);
                }
            }
        }
        return dp[x][y];
    }
}
