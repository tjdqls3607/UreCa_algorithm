package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());   // 테스트 케이스 수

        int[][] answer = new int[T][2];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            answer[i][0] = Integer.parseInt(st.nextToken());
            answer[i][1] = Integer.parseInt(st.nextToken());

            System.out.println(answer[i][0] + answer[i][1]);
        }


    }
}
