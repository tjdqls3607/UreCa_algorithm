package baekjoon;

import java.util.Scanner;

public class bj_N보다작은수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            if (a < X) {
                System.out.print(a + " ");
            }
        }
    }
}
