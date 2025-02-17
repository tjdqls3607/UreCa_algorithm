package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_NQueen {
    static int[] N;
    static int a;   // 퀸의 갯수
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());    // 배열의 크기를 정하는 정수이자 퀸의 갯수
        N = new int[a];  // 입력받은 a를 N 배열의 크기로

        nQueen(0);

    }
    static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태라면 count 1 증가
        if (depth == N.length) {
            count++;
            return;
        }

        for (int i = 0; i < N.length; i++) { //모든 열에 퀸을 놓아보면서 확인
            N[depth] = i;   //현재 행(depth)의 퀸을 i번째 열에 배치
            if (Posibility(depth)) { // 위치가 유효한지 검사
                nQueen(depth + 1);  // 가능하다면 다음행으로 재귀호출
            }
        }

    }

    static boolean Posibility(int col) { //퀸이 공격할 수 있는지 검사
        for (int i = 0; i < col; i++ ) {
            // 해당 열의 행과 i행이 일치할 경우( 같은 행에 존재할 경우)
            if (N[col] == N[i]) { // 같은 열에 퀸이 있으면 안 됨
                return false;
            } else if (Math.abs(col-1) == Math.abs(N[col] - N[i])) {
                return false;
            }
        }
        return true;
    }
}
