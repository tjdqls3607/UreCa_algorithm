package basic.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnionFind {
    static int v, e;
    static int[] parent;    // 각 원소 (정점 번호) 별 집합 관계를 표현하는 1차원 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 그래프 정점(1 ~ 6) 간 집합 표현
        // #1. 1차원 배열 생성
        parent = new int[v + 1];    // 0 는 더미이기 때문에 1을 더한다

        // #2. 1차원 배열 초기화
        // 각 원소별 자기 자신이 대표원소가 되도록 (모든 정점이 각각 서로소인 집합 )
        makeSet();
    }

    static void makeSet() {     // 각 원소들을 각자 서로다른 집합으로 만든다 ( 모든 원소들이 대표원소가 됨 )
        for (int i = 1; i <= v; i++) {
            parent[i] = i;  // 모두가 대표 원소가 됨
        }
    }
}
// 트리 : 노드 (Node), 간선 (Edge)
// 그래프 : 정점(Vertex), 간선(Edge)
/*
 6 4 <- 정점(v) , 간선 (e)
 1 4 <- 나머지는 합치는 연산
 2 3
 2 4
 5 6
 */
