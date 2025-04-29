package baekjoon;

import java.util.Scanner;

public class bj_숫자의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long m = sc.nextLong();

        long ans = n*k*m;

        int[] count = new int[10]; // 0~9까지 각 숫자 개수 저장
        String ansStr = String.valueOf(ans);
        for (int i = 0; i < ansStr.length(); i++) {
            int digit = ansStr.charAt(i) - '0';
            count[digit]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}
