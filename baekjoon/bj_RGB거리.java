package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5번째 집 칠하는 최소비용
// 5번째 집을 R 칠할때 <= 4번째 집이 G일 때 비용과 4번째 집이 B 일 때 비용 중 최소 비용 선택
// 5번째 집을 G 칠할때 <= 4번째 집이 R일 때 비용과 4번째 집이 B 일 때 비용 중 최소 비용 선택
// 5번째 집을 B 칠할때 <= 4번째 집이 R일 때 비용과 4번째 집이 G 일 때 비용 중 최소 비용 선택
public class bj_RGB거리 {
    static int N;   // 집의 개수
    static int[][] memoi;   // i 번째 선택이 3가지인
    static int[][] cost;  // 거리와 집 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());   // 집의 갯수를 입력받자

        cost = new int[N+1][3];

        for (int i = 1; i <= N; i++) {   //입력 배열 만들자
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); //R
            cost[i][1] = Integer.parseInt(st.nextToken()); //G
            cost[i][2] = Integer.parseInt(st.nextToken()); //B
        }

        // 풀이
        memoi = new int[N + 1][3];

        // 맨 앞 집에 R,G,B 각 초기화
        memoi[1][0] = cost[1][0];   // 첫 번째 집을 R 로 칠한 경우
        memoi[1][1] = cost[1][1];   // 첫 번째 집을 G 로 칠한 경우
        memoi[1][2] = cost[1][2];   // 첫 번째 집을 B 로 칠한 경우

        for (int i = 2; i <= N; i++) {
            memoi[i][0] = Math.min(memoi[i-1][1], memoi[i-1][2]) + cost[i][0];
            memoi[i][1] = Math.min(memoi[i-1][0], memoi[i-1][2]) + cost[i][1];
            memoi[i][2] = Math.min(memoi[i-1][0], memoi[i-1][1]) + cost[i][2];
        }

        System.out.println(Math.min( Math.min(memoi[N][0], memoi[N][1]), memoi[N][2] ) );

    }
}
