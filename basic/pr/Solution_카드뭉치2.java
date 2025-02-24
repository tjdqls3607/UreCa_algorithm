package basic.pr;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
public class Solution_카드뭉치2 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal)); // 완성할 기준

        while( ! goalDeque.isEmpty() ) {
            if( !cardsDeque1.isEmpty() && cardsDeque1.peek().equals(goalDeque.peek())) { // card1 에서 가능한지
                cardsDeque1.poll();
                goalDeque.poll();
            }else if( !cardsDeque2.isEmpty() && cardsDeque2.peek().equals(goalDeque.peek())) { // card2 에서 가능한지
                cardsDeque2.poll();
                goalDeque.poll();
            }else {
                break;
            }
        }

        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}