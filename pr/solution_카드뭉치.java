package pr;

import java.util.LinkedList;
import java.util.Queue;

public class solution_카드뭉치 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";

            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();

            for (String card : cards1) queue1.offer(card);
            for (String card : cards2) queue2.offer(card);

            for (String target : goal) {
                if (!queue1.isEmpty() && queue1.peek().equals(target)) {
                    queue1.poll();
                }else if (!queue2.isEmpty() && queue2.peek().equals(target)){
                    queue2.poll();
                }else {
                    return "No";
                }
            }
            return "Yes";
        }
    }
}
