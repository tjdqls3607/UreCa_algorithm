package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class bj_2의보수 {
    static int N, M , j, count;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        M = ~N + 1; // 2의 보수 계산 (비트 반전후 1 더하기)

        j = N ^ M;  //XOR 계산

        count = 0;
        for (char c : Integer.toBinaryString(j).toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);

    }
}
