package practice;

import java.util.Arrays;
import java.util.Collections;

public class distinct {
    private static int[] solution(int[] arr) {

        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);   // 중복 제거
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
