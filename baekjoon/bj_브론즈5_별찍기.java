package baekjoon;

import java.util.Scanner;

public class bj_브론즈5_별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
            System.out.print("*");
            }
            System.out.println();
        }
    }
}
