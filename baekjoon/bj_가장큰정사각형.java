package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_가장큰정사각형 {
    static int[][] map;
    static int N,M;
    static int[][] memoi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 첫째 줄 입력
        M = Integer.parseInt(st.nextToken());   // 첫째 줄 입력

        map = new int[N][M];    // 배열 크기
        memoi = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {   // 배열 입력 받자
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자 '0' 또는 '1'을 숫자로 변환
            }
        }

        int mSize = 0;  // 사이즈

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {    // 정사각형을 만족하려면 1이 있어야함
                    if (i == 0 || j == 0 ) {
                        memoi[i][j] = 1;
                    }else{
                        memoi[i][j] = Math.min(Math.min(memoi[i-1][j], memoi[i][j-1]), memoi[i-1][j-1]) + 1;
                    }    //보조강사님 점화식 : 정사각형을 만족하기 위해서 각 방향의 최소값을 찾은 후 현재 위치에서 정사각형을 만족하는
                    // 크기를 결정
                    mSize = Math.max(mSize, memoi[i][j]);    // 크기가 큰 정사각형 갱신
                }
            }
        }
        System.out.println(mSize*mSize);

    }
}
