package baekjoon;

import java.util.Scanner;
import java.util.Stack;


public class bj_문자열뒤집기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean flag = false;   // 체크

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                print(stack);
                flag = true;    // '<' 태그있으면 1
                System.out.print(s.charAt(i));
            }else if (s.charAt(i) == '>') {
                 flag = false;
                 System.out.print(s.charAt(i));
            }else if (flag) {   // '>' 오기 전까지 문자 출력
                System.out.print(s.charAt(i));
            }else { // 태그가 아니면
                if (s.charAt(i) == ' ') { //공백일 때
                    print(stack);
                    System.out.print(s.charAt(i));
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        print(stack);

    }
    public static void print(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
