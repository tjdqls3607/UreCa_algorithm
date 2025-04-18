package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_부분수열의합 {
    static int N,S, answer; // 정수의 개수, 정수의 합, 답
    static int[] num;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        N = sc.nextInt();
        S = sc.nextInt();

        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        dfs(0, 0);  //DFS (깊이 우선 탐색) 방식으로 각 숫자를 선택하거나 선택하지 않는 경우를 나누어 전체 조합을 탐색

        if (S==0) System.out.println(answer - 1);       // 합이 0인 부분수열 중 공집합은 제외해야 하므로, S == 0일 땐 answer - 1을 출력
        else System.out.println(answer);
    }
    private static void dfs(int i, int j) {
        if (i == N) {           // dfs(i, j)은 i번째 숫자를 보고 있고, 현재까지의 합이 j일 때,
            if (j == S) answer++;
            return;
        }
        dfs(i + 1, j + num[i]);  // num[i]를 더하는 경우 (선택)
        dfs(i + 1, j);  // 더하지 않는 경우 (선택 안 함)
    }

}
