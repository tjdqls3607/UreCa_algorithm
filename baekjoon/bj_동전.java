package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_동전 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        N = Integer.parseInt(st.nextToken());   // 동전의 종류
        int K = Integer.parseInt(br.readLine());    // 적절히 조합한 가치의 합

        int[] coins = new int[N];
        int count = 0; // 최소 동전 개수

        for (int i = 0; i < N; i++) {   // 동전 좋류 입력받기
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N-1; i>=0; i--){    // 큰 동전부터 사용
            if (K >= coins[i]){ // 현재 동전으로 K를 채울 수 있으면
                count += K / coins[i]; // 해당 동전개수 추가
                K %= coins[i];  // 남은 금액 조회
            }
        }
        System.out.println(count);
    }
}
