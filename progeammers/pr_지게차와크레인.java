package progeammers;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Node {        // bfs 좌표 노드 x, y 저장
    int x;
    int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class pr_지게차와크레인 {
    String[][] map;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    int n,m;
    public int solution(String[] storage, String[] requests) throws IOException {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        map = new String[n+2][m+2]; // 바깥 경게 포함하기 위해 +2

            for (int i = 0; i < n+2; i++) { // 배열 채워넣기
                Arrays.fill(map[i], "-1");
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i+1][j+1] = String.valueOf(storage[i].charAt(j));
                }
            }

            for (int i=0; i<requests.length; i++) { // 요청 처리 로직
                String target = requests[i];
                bfs();
                if (target.length() == 2) removeAll(String.valueOf(target.charAt(0))); //  target 이 두번 선언 되면, 크레인 제거
                else remove (target);   // 지게차 제거
            }

            for (int i=1; i<=n; i++) { // 나머지 박스 갯수 세기
                for (int j=1; j<=m; j++) {
                    if (map[i][j].equals("-1")) continue; // -1 인 부분은 건너뛰고 세기 -1 이 벽이기 때문
                    answer++;
                }
            }
            return answer;
    }

    void bfs() {
        visited = new boolean[n+2][m+2];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int k=0; k<4; k++) {
                int nx = dx[k] + cur.x;
                int ny = dy[k] + cur.y;
                if (nx < 0 || ny < 0 || nx >= m+2 || ny >= n+2) continue;
                if (visited[ny][nx] || map[ny][nx] != "-1") continue;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }
    }

    void removeAll(String target) { // 요청이 2개들어왔을 때 크레인으로 storage 에 있는 해당 요청 다 삭제
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j].equals(target)) map[i][j] = "-1"; // 요청과 같은 문자면 map에있는 문자를 -1로
            }
        }
    }

    void remove(String target) { // 외부에서 접근가능한 칸을 가지면 삭제
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j].equals(target)) {
                    if (check(j,i)) map[i][j] = "-1";   // 벽(-1) 존재하는지 확인후 -1 로 변환
                }
            }
        }
    }

    boolean check(int i, int j) {   // 상하좌우 탐색해서 true 인 지점이 있으면 true 리턴
        for (int k=0; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (visited[ny][nx]) return true;
        }
        return false;
    }
}
