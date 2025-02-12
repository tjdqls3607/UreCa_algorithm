package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack2 {
    static int N, s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        N = Integer.parseInt(br.readLine());    // 스택에 들어갈 총 수
        s = Integer.parseInt(st.nextToken());   // 스택에 들어가는 수 ( 토크나이저로 분할 )

        Stack<Integer> stack = new Stack<Integer>();



    }
}
