package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack2 {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 명령어의 수

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solve(st);
        }

        System.out.println(sb);
    }

    static void solve(StringTokenizer st) {
        String command = st.nextToken();

        switch (command) {
            case "1": // push X
                stack.push(Integer.parseInt(st.nextToken()));
                break;
            case "2": // pop
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                break;
            case "3": // size
                sb.append(stack.size()).append("\n");
                break;
            case "4": // empty
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                break;
            case "5": // top
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                break;
        }
    }
}
