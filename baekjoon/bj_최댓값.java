package baekjoon;

import java.io.BufferedReader;
import java.lang.Math;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MaxVal = Integer.MIN_VALUE;
        int index = 0;

        for (int i=1; i<=9; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n > MaxVal) {
                MaxVal = n;
                index = i;
            }

        }
        System.out.println(MaxVal);
        System.out.println(index);
    }
}
