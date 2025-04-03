package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;


public class bj_최소최대 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int MaxValue = Integer.MIN_VALUE;
        int MinValue = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            MinValue = Math.min(MinValue, num);
            MaxValue = Math.max(MaxValue, num);
        }
        System.out.println(MinValue + " " + MaxValue);
    }
}
