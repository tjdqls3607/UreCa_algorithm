package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_피보나치수3 {
    static final int MOD = 1000000;
    static final int PISANO = 1500000; // 피사노 주기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // 피사노 주기 활용: n을 1,500,000으로 나눈 나머지만 계산
        int index = (int) (n % PISANO);

        // 피보나치 수열을 MOD로 나눈 값만 저장 (배열 크기 1,500,000이면 충분)
        int[] fibo = new int[PISANO];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < PISANO; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }

        System.out.println(fibo[index]); // n번째 피보나치 수 출력
    }
}