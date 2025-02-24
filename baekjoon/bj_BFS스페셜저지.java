package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_BFS스페셜저지 {
    static Queue<Integer> q = new LinkedList<>();
    static int N;   // 정점의 개수
    static boolean[] visited;   // 방문 처리 배열
    static ArrayList<Integer>[] graph;
    static int[] visitgrade;    // 방문 순서
    static int[] a; // 방문 순서 배열에서 정점들을 여기다 저장
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수

        graph = new ArrayList[N+1]; // 인접리스트 그래프 (인덱스가 1부터 시작하기 때문에 +1 필요
        visited = new boolean[N+1];
        visitgrade = new int[N+1];
        a = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력하는 코드
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            graph[a].add(vertex);
            graph[vertex].add(a);
        }

        // 방문 순서를 입력해야돼
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            visitgrade[i] = Integer.parseInt(st.nextToken());
            a[visitgrade[i]] = i;
        }

        // 정점들의 방문 순서를 기준으로 정렬
        for (int i = 1; i <= N; i++) {
            graph[i].sort(Comparator.comparingInt(o -> a[o]));
        }

        System.out.println(isValid() ? 1  : 0);

    }

    static boolean isValid() {
        q.offer(1); // 문제의 시작정점이 1이었으니 방문 큐에 1 시작
        visited[1] = true;
        int index = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur != visitgrade[index]) return false;
            index++;

            for (int nx : graph[cur]) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.offer(nx);
                }
            }
        }
        return true;
    }
}
