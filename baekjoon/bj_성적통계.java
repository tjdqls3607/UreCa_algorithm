package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_성적통계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine()); // 반의 개수

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 학생 수
            int[] scores = new int[n]; // 현재 반의 성적 저장 배열

            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(st.nextToken()); // 성적 입력
            }

            // 성적 정렬
            Arrays.sort(scores);

            // 최대값, 최소값, 최대 차이 계산
            int max = scores[n - 1];
            int min = scores[0];
            int largestGap = 0;

            // 최대 차이(Largest gap) 계산
            for (int j = 1; j < n; j++) {
                largestGap = Math.max(largestGap, scores[j] - scores[j - 1]);
            }

            // 원하는 형식으로 출력
            System.out.println("Class " + (i + 1));
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + largestGap);
        }
    }
}
