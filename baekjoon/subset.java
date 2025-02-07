import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] S, B;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 재료 개수 입력

        S = new int[n]; // 신 맛 저장 (곱)
        B = new int[n]; // 쓴 맛 저장 (합)

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        subset(0, 1, 0, 0); // 부분집합을 생성하여 차이 계산

        System.out.println(minDiff);
    }

    static void subset(int idx, int sour, int bitter, int count) {
        if (idx == n) {
            if (count > 0) { // 적어도 하나의 재료를 선택한 경우
                minDiff = Math.min(minDiff, Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료를 선택하는 경우
        subset(idx + 1, sour * S[idx], bitter + B[idx], count + 1);

        // 현재 재료를 선택하지 않는 경우
        subset(idx + 1, sour, bitter, count);
    }
}
