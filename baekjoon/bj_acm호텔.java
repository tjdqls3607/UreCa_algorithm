package baekjoon;

import java.util.Scanner;

public class bj_acm호텔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (c % a == 0) {
                System.out.println((a * 100) + (c / a));
            }else {
                System.out.println(((c%a) * 100) + (c / a) + 1);
            }
        }
    }
}
