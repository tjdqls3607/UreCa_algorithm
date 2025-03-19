package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_트리의부모찾기 {
    static int N;
    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 입력
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[N+1];
        visited = new boolean[N+1];

        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int child : tree[cur]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parent[child] = cur;    // 현재 노드가 자식의 부모
                    queue.add(child);
                }
            }
        }
    }
}
