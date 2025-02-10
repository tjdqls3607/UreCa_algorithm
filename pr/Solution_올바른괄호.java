package pr;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_올바른괄호 {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(new Solution_올바른괄호().solution(s));
    }
    // s 문자열의 각 문자 한 개씩 고려
    // '(' : 뒤에서 닫는 ')' 만나면 함꼐 유효한 문자이므로 일단 자료구조(stack)에 저장
    // ')' : 바로 이전 문자 (Stack 에서 pop()) '(' 이어야 유효 => 유효한 2개 문자는 제거
    boolean solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        char[] a = s.toCharArray();  // s.charAt(i) 로 처리 가능
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            }else {  // c 가 ')' 닫는 괄호
                // 닫는 괄호에 대응하는 여는 괄호가 대칭되면 return false 없이
                // Stack 에서 꺼내어 지고 결국 자료구조에서 지워진다 ('(')
                if (stack.isEmpty() || stack.pop() == c) return false;
            }
        }
        return stack.isEmpty();
    }
}
