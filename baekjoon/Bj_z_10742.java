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

    }
}
