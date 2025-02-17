package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_스도쿠2 {
    static int[][] puz;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        puz = new int[9][9];

        // 9x9 스도쿠 배열 입력 받기
        for (int i = 0; i < puz.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < puz[i].length; j++) {
                puz[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 스도쿠 해결 함수 호출 (빈 자리를 작은 수부터 채우는 로직 구현)
        solve(0, 0);
    }

    // 스도쿠를 해결하는 재귀 함수
    static boolean solve(int row, int col) {
        if (row == 9) return true;  // 모든 행을 채우면 끝
        if (col == 9) return solve(row + 1, 0);  // 열이 끝나면 다음 행으로

        // 이미 채워진 곳은 건너뜀
        if (puz[row][col] != 0) {
            return solve(row, col + 1);  // 다음 열로 넘어감
        }

        // 1부터 9까지 숫자를 시도
        for (int num = 1; num <= 9; num++) {
            if (isSafe(row, col, num)) {  // 해당 숫자가 안전한지 확인
                puz[row][col] = num;  // 숫자 채우기
                if (solve(row, col + 1)) {
                    return true;  // 만약 해결되면 true
                }
                puz[row][col] = 0;  // 실패하면 되돌림
            }
        }
        return false;  // 모든 숫자를 시도해봤지만 해결되지 않으면 false
    }

    // 해당 숫자가 주어진 위치에서 유효한지 검사
    static boolean isSafe(int row, int col, int num) {
        // 같은 행에 같은 숫자 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (puz[row][i] == num) return false;
        }
        // 같은 열에 같은 숫자 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (puz[i][col] == num) return false;
        }
        // 3x3 박스 안에 같은 숫자 있는지 확인
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (puz[i][j] == num) return false;
            }
        }
        return true;
    }
}
