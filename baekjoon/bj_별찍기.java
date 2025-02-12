package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_별찍기 {

    static char[][] board;
    static void makeBlank(int xStart, int yStart, int totalSize) {
        if (totalSize == 1) {
            return;
        }

        int size = totalSize / 3;

        // Divide (문제를작은 단위로 분할)
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (x == 1 && y == 1) continue;
                    makeBlank(xStart + x * size, yStart + y * size, size);
            }
        }

        for (int x = xStart + size; x < xStart + size * 2; x++) {
            for (int y = yStart + size; y < yStart + size * 2; y++) {
                board[x][y] = ' ';
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '*');
        }

        makeBlank(0, 0, n);

        // 출력
        for (int i = 0; i < n; i++) {
            System.out.println(board[i]);
        }

        br.close();

    }
}
