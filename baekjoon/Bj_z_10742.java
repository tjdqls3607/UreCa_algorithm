package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀 호출
public class Bj_z_10742 {
    static int N, r, c, ans;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 풀이
        N = (int)Math.pow(2, N);    // 2의 제곱수 이므로 계속 반으로 나눌 수 있다.

        z(0,0);

        System.out.println(ans);
    }
    static void z(int y, int x) {
        // 기저조건
        if (N == 1) return;

        N /= 2;

        // r,c 가 4개의 영역중 어디에 있는지 판단
        if (r < y + N && c < x +N) {    // 상좌
            z(y , x);
        }else if (r < y + N && c >= x + N) {    //상우
            ans += N * N * 1;
           z (y, x + N); // 원점 우로 이동
        }else if (r >= y + N && c < x + N) {    // 하좌
            ans += N * N * 2;
            z(y + N, x);// 원점 하로 이동
        }else {
            ans += N * N * 3;
            z( y + N, x + N);
        }

    }
}
