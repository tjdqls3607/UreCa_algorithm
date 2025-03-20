package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());   // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder(); // 결과를 한 번에 출력하기 위해 사용

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());  // 반복 횟수
            String S = st.nextToken();  // 반복할 문자열

            for (char c : S.toCharArray()) {
                sb.append(String.valueOf(c).repeat(R));
            }
            sb.append("\n");
        }

        System.out.print(sb.toString()); // 최종 결과 한 번에 출력
    }
}
