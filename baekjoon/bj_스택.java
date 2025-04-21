package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj_스택 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String cmd = sc.nextLine();
            if (cmd.startsWith("push")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                stack.push(num);
            }else if (cmd.equals("pop")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.pop());
            }else if (cmd.equals("top")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.peek());
            }else if (cmd.equals("size")) {
                System.out.println(stack.size());
            }else if (cmd.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
        }
    }
}
