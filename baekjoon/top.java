package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class top {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < towers[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek()[1] + 1;
            }

            stack.push(new Integer[]{towers[i], i});
        }

        for (int answers : answer) {
            str.append(answers).append(" ");
        }

        System.out.println(str.toString().trim());
    }
}
