package baekjoon;

import java.util.Scanner;

public class bj_문자와문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        char answer = s.charAt(n-1);

        System.out.println(answer);
    }
}
