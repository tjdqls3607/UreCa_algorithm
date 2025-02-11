package basic.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeSearch {

    static int[] tree = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    static StringBuilder sb = new StringBuilder();
    // 포화이진트리 (perfect binary tree) vs 완전이진트리 (complete binary tree)
    public static void main(String[] args) {
        bfs(1);
        System.out.println(sb);

        sb.setLength(0);

        dfs(1);
        System.out.println(sb);
    }

    static void bfs(int idx) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);

        while (!q.isEmpty()) {
            int curIdx = q.poll();
            sb.append(tree[curIdx]).append(" ");

            // 꺼낸 노드의 자식 노드 방문
            int lcIdx = curIdx * 2;
            int rcIdx = curIdx + 1;

            // range check
            if (lcIdx < tree.length) q.offer(lcIdx);
            if (rcIdx < tree.length) q.offer(rcIdx);
        }
    }

    static void dfs(int idx) {
        // 기저조건
        if (idx >= tree.length) return;

        sb.append(tree[idx]).append(" ");

        // 현재 노드의 자식 노드 방문
        // 왼쪽
        dfs(idx * 2);
        // 오른쪽
        dfs(idx * 2 + 1);

    }
}
