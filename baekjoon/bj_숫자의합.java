package baekjoon;


import java.io.IOException;

import java.util.Scanner;


public class bj_숫자의합 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String numstr = sc.next();
        int sum = 0;

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            sum += numstr.charAt(i) - '0';
        }
        System.out.println(sum);



    }
}
