package baekjoon;

import java.util.*;

public class bj_크림파스타 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int minValue = A[0];
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(" "); // 첫 번째 값은 무조건 0

        for (int i = 1; i < N; i++) {
            int diff = A[i] - minValue;
            sb.append(diff).append(" ");
            minValue = Math.min(minValue, A[i]); // 지금까지의 최소값 갱신
        }

        System.out.println(sb.toString().trim());
    }
}
