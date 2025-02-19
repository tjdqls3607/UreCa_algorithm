package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP
// N 을 만들기 위해 사용할 수 있는 수는 3,5  2가지
// N <= N-3 에서 3을 쓰는 방법 < N-3 을 만드는데 사용한 최소 봉지 수
//   <= N-5 에서 5를 쓰는 방법 < N-5 를 만드는데 사용한 최소 봉지 수
//   중 최소값을 선택 + 1
public class bj_설탕배달 {

    static int N;
    static int[] memoi = new int[N+1];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memoi = new int[N + 1];

        memoi[3] = 1;
        memoi[5] = 1;

        for (int i = 6; i <= N; i++) {
            memoi[i] = memoi[i - 6] + memoi[i - 3];
            if (memoi[i] > 1) {
            }
        }
        System.out.println(memoi[N]/2);

    }
}
