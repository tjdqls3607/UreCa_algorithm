package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_스도쿠 {
    static int[][] puz;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        puz = new int[9][9];

        for (int i = 0; i < puz.length; i++) {      // 9X9 배열 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < puz[i].length; j++) {
                puz[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0);

    }
    static boolean solve(int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solve(row+1, 0);

        // 이미 채워진 곳은 건너 뛴다
        if (puz[row][col] != 0) return solve(row , col + 1);
    }
}
