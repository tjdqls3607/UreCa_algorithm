package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_숨바꼭질 {
    static int N, M;
    static boolean[] visited;
    static int max = 100000;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];
        bfs();
        System.out.println(result);
    }
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N,0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int time = cur.time;
            visited[x] = true;

            if (x == M) result = Math.min(result, time);

            if(x * 2 <= max&&visited[x*2] == false) q.offer(new Node(x*2,time));
            if(x + 1 <= max&&visited[x+1] == false) q.offer(new Node(x+1,time+1));
            if(x - 1 >= 0&&visited[x-1] == false) q.offer(new Node(x-1,time+1));
        }
    }
    static class Node {
        int x, time;
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}
