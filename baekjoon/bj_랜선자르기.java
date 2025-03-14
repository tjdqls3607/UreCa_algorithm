package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_랜선자르기 {
    static int N,K; // 이미 가지고 있는 랜선의 개수 K 필요한 랜선의 개수 N;
    static int[] length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        length = new int[K];

        for (int i = 0; i < K; i++) {   //랜선 입력 받기
            length[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(length);

        System.out.println(binarySearch());
    }
    static long binarySearch() {
        long left = 1, right = length[K-1];    // right 는 가장 긴 랜선 길이
        long maxLen = 0;    // 최대길이 초기화

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int len : length) {
                count += len / mid;
            }

            if (count >= N) {
                maxLen = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxLen;
    }
}
