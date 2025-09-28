package progeammers;

import java.util.HashMap;
import java.util.Map;

public class pr_대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int [targets.length];
            Map<Character, Integer> map = new HashMap<>();
            for (String k : keymap) {
                for (int i = 0; i < k.length(); i++) {
                    char ch = k.charAt(i);
                    if (!map.containsKey(ch) || map.get(ch) > i+1) {
                        map.put(ch, i+1);
                    }
                }
            }
            for (int j = 0; j < targets.length; j++) {
                String target = targets[j];
                int sum = 0;
                for (int k=0; k<target.length(); k++) {
                    char ch = target.charAt(k);
                    if (!map.containsKey(ch)) {
                        sum = -1;
                        break;
                    }else {
                        sum += map.get(ch);
                    }
                }
                answer[j] = sum;
            }
            return answer;
        }
    }
}
