package progeammers;
import java.util.*;

public class pr_두개뽑아서더하기 {

    class Solution {
        public int[] solution(int[] numbers) {
            HashSet<Integer> set = new HashSet<>(); // 중복값 제거를 위한 해시셋

            for (int i=0; i<numbers.length-1; i++){
                for (int j=i+1; j<numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
}
