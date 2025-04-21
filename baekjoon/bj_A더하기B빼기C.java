package baekjoon;

import java.util.Scanner;

public class bj_A더하기B빼기C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(A + B - C);
        int D = Integer.parseInt(Integer.toString(A) + Integer.toString(B));
        System.out.println(D - C);
    }
}
