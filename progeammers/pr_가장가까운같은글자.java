package progeammers;

import java.util.HashMap;
import java.util.Map;

public class pr_가장가까운같은글자 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            Map<Character, Integer> lastIndex = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!lastIndex.containsKey(c)) {
                    answer[i] = -1;
                }else {
                    answer[i] = i - lastIndex.get(c);
                }
                lastIndex.put(c, i);
            }
            return answer;
        }
    }
}
