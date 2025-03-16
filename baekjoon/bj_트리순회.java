package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_트리순회 {
    static int N;   // 노드의 개수
    static Node[] tree;

    static class Node {
        char a;
        Node left, right;

        Node(char a) {
            this.a = a;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        tree = new Node[26];    // 알파벳의 개수 만큼 노드

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);


            // Node 를 입력받고 처리 하는 로직인데 좀더 공부 해야 할듯
            if(tree[root - 'A'] == null) tree[root - 'A'] = new Node(root);
            if(left != '.')tree[left - 'A'] = new Node(left);
            if(right != '.')tree[right - 'A'] = new Node(right);

            tree[root - 'A'].left = ( left=='.') ? null : tree[left-'A'];
            tree[root - 'A'].right = ( right == '.') ? null : tree[right-'A'];
        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
        System.out.println();
    }

    static void preorder(Node root) { // 전위 순회
        if(root == null) return;
        System.out.print(root.a);
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {    // 중위 순회
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.a);
        inorder(root.right);
    }

    static void postorder(Node root) {  // 후위 순회
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.a);
    }
}
