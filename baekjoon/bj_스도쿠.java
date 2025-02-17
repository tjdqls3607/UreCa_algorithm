package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
// dfs + 백트래킹
// 0인 모든 좌표를 zero 라는 ArrayList 에 저장 <= 2차원 배열 순회하면서 0 처리 X
// zero 의 0 번째 좌표부터 시작 ~ zero 총 전체 0 인 모든 좌표를 다 채우면 정답
// 0인 y, x 좌표에 1 ~9 의 숫ㅅ자로 채우기 전에 visit 배열을 이용 가로, 세로, 3x3 영역에서 사용된 수를 제외한 후 놓아 본다.
// 다음 0 인 좌표에 위 작업을 반복
// zero 의 모든 좌표에 수를 다 놓으면 종료
public class bj_스도쿠 {
    static int[][] map = new int[9][9];
    static List<Node> zero = new ArrayList<>();
    static int size;    // zero 의 size
    static boolean complete;    //false
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                int n = line[j] - '0';
                map[i][j] = n;
                if (n == 0) zero.add(new Node(1, 1));
            }
        }
        size = zero.size();
        dfs(0);

    }

    static void dfs(int idx) { // zero ArrayList 로 인덱스
         if (complete) return;


        // 기저조건
        if(idx == size ) { // 모든 빈칸을 다 채움 스도쿠가 완성

            complete = true; // 직업 완료 flag 설정
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }

            System.out.println(sb);

            return;
        }

        // 현재 idx 번째 0인 항목의 y,x 구한다
        int x = zero.get(idx).x;
        int y = zero.get(idx).y;

        // map 의 y,x 자리에 1~9 숫자를 채워 본다 (단, 가로, 세로, 3x4 에 사용되지 않은 수)

        boolean[] visit = new boolean[10];  // 0 dummy

        // 가로에 사용된 수 check
        for (int i = 0; i < 9; i++) {
            if(map[y][i] != 0) visit[map[y][i]] = true;
        }
        // 세로에 사용된 수 check
        for (int i = 0; i < 9; i++) {
            if(map[i][x] != 0) visit[map[i][x]] = true;
        }
        // 3x3에 사용된 수 check
        int ny = (y / 3) * 3;
        int nx = (x / 3) * 3;
        int ny3 = ny+3;
        int nx3 = nx+3;
        for (int i = ny; i < ny3; i++) {
            for (int j = nx; j < nx3; j++) {
                if (map[i][j] != 0) visit[map[i][j]] = true;
            }
        }

        // visit 에 사용되지 않은 수에 대해 다음 재귀호출 ( 다음 0인 자리) 를 진행
        for (int i = 0; i <= 9; i++) {
            if (! visit[i]) {
                map[y][x] = i;
                dfs(idx+1);
            }
        }
    }

    // 0 (빈) 좌표를 표현 ,zero 담을 객체
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
