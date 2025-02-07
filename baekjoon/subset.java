package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class subset {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 첫 번째 입력: n

        int[] S = new int[n]; // 신 맛 저장 (곱)
        int[] B = new int[n]; // 쓴 맛 저장 (합)

        int by = 1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            for (int j = i + 1; j < S.length; j++) {
                by *= S[j];
            }
            for (int j = i + 1; j < B.length; j++) {
                int sum = 0;
                sum += B[j];
            }
            System.out.println(by-sum);
        }


    }
    static   void printSubset() {
        System.out.println()

    }
}
