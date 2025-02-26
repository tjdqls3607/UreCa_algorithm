package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n >= 0) {
            if (n % 5 == 0) {   // 5의 배수일 때
                count += n/5;   // 5원 개수만큼 카운트 증가
                System.out.println(count);
                return;
            }
            n -= 2; // 2를 빼면서 2원짜리 카운트 증가
            count++;

        }
        System.out.println(-1);
    }
}
