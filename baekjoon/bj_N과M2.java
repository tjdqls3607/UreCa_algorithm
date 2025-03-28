package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_N과M2 {
    static int N,M;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        combination(1,0);   //조합 생성 시작
    }
    static void combination(int i, int j) {
        if (j == M) {   // M개 선택이 끝나면 출력
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int num = i; num <= N; num++) {
            arr[j] = num;   // 숫자 선택후 재귀 호출
            combination(num + 1, j + 1);
        }
    }
}
