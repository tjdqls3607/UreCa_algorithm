package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_dfsbfs {
    static int N, M, V; //정점의 갯수, 간선의 갯수, 탐색을 시작할 정점의 번호
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {  // 그래프 입력받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {  // 정점 값이 작은거 부터
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(result.toString().trim());


        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(result.toString().trim());
    }
    static void dfs(int x) {
        visited[x] = true;
        result.append(x).append(" ");

        for (int next : graph[x]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.append(cur).append(" ");

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                }
            }
        }
    }
}
