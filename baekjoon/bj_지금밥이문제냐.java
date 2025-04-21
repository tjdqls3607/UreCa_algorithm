package baekjoon;

import java.util.*;

import java.math.BigInteger;

public class bj_지금밥이문제냐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int mode = Integer.parseInt(input[0]);
            String value = input[1];

            if (mode == 1) {
                // IPv8 -> 부호 없는 정수 (BigInteger)
                String[] parts = value.split("\\.");
                BigInteger result = BigInteger.ZERO;
                for (String part : parts) {
                    int byteVal = Integer.parseInt(part);
                    result = result.shiftLeft(8).or(BigInteger.valueOf(byteVal));
                }
                System.out.println(result);
            } else {
                // 부호 없는 정수 -> IPv8
                BigInteger num = new BigInteger(value);
                StringBuilder sb = new StringBuilder();
                for (int i = 7; i >= 0; i--) {
                    BigInteger mask = BigInteger.valueOf(255);
                    BigInteger byteVal = num.shiftRight(i * 8).and(mask);
                    sb.append(byteVal);
                    if (i != 0) sb.append(".");
                }
                System.out.println(sb);
            }
        }
    }
}
