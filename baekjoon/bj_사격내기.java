package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bj_사격내기 {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        C = A ^ B;
        System.out.println(C);
    }
}
