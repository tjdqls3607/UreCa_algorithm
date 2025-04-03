package baekjoon;

import java.util.Scanner;

public class bj_막대기 {
    static int X;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        int count = 0;

        while (X > 0) {
            count += X&1;   // 마지막 비트가 1인지 확인

            X>>=1;  // X의 비트를 오른쪽 한 칸으로 이동
        }

        System.out.println(count);
        sc.close();
    }
}
