package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시뮬레이션
// 3가지 큰 처리가 반복 ( 낚시왕이 이동해서 상어를 잡는다 => 상어들이 이동 => 겹치는 상어를 정리 )
// shark 5개 필드를 가지는 클래스 정의
// 이차원 배열 + ArrayList 사용
// s (스피드) 에 따른 상어 각각의 이동시 s 만큼 움직이면 시간 손해
// => 좌우 또는 상하 이동 과정에서 제자리로 복귀하는 count 미리 계산해서 s (스피드)
// 를 나눈 나머지만 실제로 이동
public class bj_낚시왕 {

    static int R, C, M, sum; // 잡은 상어크기의 합
    static Shark[][] map;
    static List<Shark> List = new ArrayList<>();

    // 상 -> 하 -> 우 -> 좌 (순서 필요)
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d - 1, z);  // 문제의 상하우좌 가 1234로 된 부분 보정
            List.add(shark);
            map[r][c] = shark;
        }

        // 상어 잡기 시작
        // 반복횟수 ( 컬럼 길이) 고정 => for
        for (int i = 0; i < C; i++) {
            catchShark(i);  // col 전달
            moveShark();
            killShark();
        }

        System.out.println(sum);

    }

    // 현재 자리에서 상어 잡기
    static void catchShark( int col ) {
        // 밑으로 (row) 내려가면서 상어를 만나면 sum 추가,list 제거, 어차피 전체
        // 뒤에서 한꺼번에 list를 이용해서 map 정리한다.
        for (int i = 1; i <= R; i++) {
            if (map[i][col] != null) {
                sum += map[i][col].z;
                List.remove(map[i][col]);
                break;
            }
        }
    }

    static void moveShark() {

    }

    // 같은 위치의 큰 상어가 작은 상어를 잡아 먹는다
    static void killShark() {

    }

    static class Shark {
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z) {
            this.r = r; this.c = c; this.s = s; this.d = d; this.z = z;
        }
    }
}
