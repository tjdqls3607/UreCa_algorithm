package basic.bfsdfs;

import java.util.*;

// 그래프 자료구조 중 인접 행렬
// 재방문 X <- visit
// 가중치 X, 유향 = > 자료구조 활용, 방문 순서 집중!!

public class DFS_BFS_Graph_Test1 {

    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit;   // 정점에 대해서 관리
    public static void main(String[] args) {
        // 정점 1, 2, 3, 4 와 연결 간선을 직접 처리
        // 정점의 개수만큼 ArrayList 객체를 adjList 에 추가
        // 정점번호의 dummy 가 있을 경우 dummy 를 위한 ArrayList 도 같이 추가
        for (int i = 0; i < adjList.size(); i++) {
            adjList.add(new ArrayList<Integer>());  // 0 번째는 dummy
        }
        // 간선
        // 1 -> 2, 4
        // 2 -> 3, 4
        // 3 -> 2
        // 4 -> 3
//      adjList.get(1);   <= 1 번 정점을 위한 ArrayList 객체 획득
        adjList.get(1).add(2);
        adjList.get(1).add(4);
        adjList.get(2).add(3);
        adjList.get(2).add(4);
        adjList.get(3).add(2);
        adjList.get(4).add(3);

        // visit 초기화
        visit = new boolean[5]; // 0 dummy

//        dfs(1); // 시작 정점 1

        bfs(1);
    }

    static void dfs(int v) {
        // 해당 정점에서 할 일 진행
        visit[v] = true;
        System.out.print(v + " -> ");

        // dfs() 이어 갈 수 있는 다음 정점 방문
        List<Integer> list = adjList.get(v);
        for (Integer i : list) {
            if (visit[i]) continue;  // 갈 수 없거나, 이미 방문한 정점 제외
            dfs(i);
        }
    }
    static void bfs(int sv) {
        // 시작 Node 를  queue 에 넣고 출발
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(sv);
        visit[sv] = true;

        while (!q.isEmpty()) {

            int v = q.poll();
            System.out.print(v + " -> ");

            List<Integer> list = adjList.get(v);
            for (Integer i : list) {
                if (visit[i]) continue;  // 갈 수 없거나, 이미 방문한 정점 제외
                q.offer(i);
                visit[i] = true;
            }
        }
    }
}
