package baekjoon;

import java.util.Scanner;

public class bj_두수비교하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n > m) System.out.println(">");
        if (n < m) System.out.println("<");
        if (n == m) System.out.println("==");
    }
}
