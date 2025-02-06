package basic.delta;

import java.util.Arrays;

// 특정 위치에서 4방 탐색을 진행하는 경우, if-else if-elseif-else <- 코드의 길이가 길어지고, 가독성이 떨어지고 나누어서생각하고
// => 실수하기 쉽다
public class DeltaTest1 {

    static char[][] map = new char[5][5];
    public static void main(String[] args) {
        char ch = 'A';
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                map[i][j] = ch++;
            }
        }
        // 출력
        for (int i=0; i<5; i++) {
            System.out.println(Arrays.toString(map[i]));

        }

        // 4방 탐색 - 상-하-좌-우
//        int y = 2;
//        int x = 2;
//
//        System.out.println(map[y][x]);

        print4x(2,2);
    }

    // delta : 이동 방향에 대해서 y의 변화량 x의 변화량을 미리 배열에 저장하고 이를 활용해서 새로운 이동좌표를 구하는 방식
    static int[] dy = { -1, 1, 0, 0};
    static int[] dx = { 0, 0, -1, 1};
    static void print4x(int y, int x){

        for (int d = 0; d < 4; d++) {
            // y,x에서 현재 d방향으로 이동한 새로운 좌표 계산
            int ny = y + dy[d];
            int nx = x + dx[d];

            System.out.println(map[ny][nx]);
        }

    }
}
