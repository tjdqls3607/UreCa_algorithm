package progeammers;

import java.util.Stack;

public class pr_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
       Stack<Integer> stack = new Stack<>();
       for (int i= numbers.length-1; i>=0; i--){
           while (!stack.isEmpty() && stack.peek() <= numbers[i]){
               stack.pop();
           }
           answer[i] = stack.isEmpty() ? -1 : stack.peek();
           stack.push(numbers[i]);
       }

        return answer;
    }
}
