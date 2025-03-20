package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_트리 {
    static int N; // 노드의 개수
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 노드의 개수

        int[] parent = new int[N];      // 두번째 줄 부모노드 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }

        int deleteNode = Integer.parseInt(br.readLine());   // 지울 노드의 번호

        List<Integer>[] tree = new ArrayList[N];  // 객체 배열 선언
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();  // 각 인덱스를 ArrayList로 초기화
        }

        for (int i = 0; i < N; i++) {
            if (parent[i] != -1) {
                tree[parent[i]].add(i); // 부모의 자식 리스트에 해당 노드를 추가
            }
        }

        System.out.println(countLeafNodes(tree, deleteNode, N));
    }
    static int countLeafNodes(List<Integer>[] tree, int deleteNode, int N) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (i != deleteNode && tree[i].size() ==0) {    // 지울 노드는 무시 자식이 없으면 리프 노드
                count ++;
            }
        }
        return count;
    }
}
