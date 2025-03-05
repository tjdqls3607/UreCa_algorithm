package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 숫자를 문자열로 처리
        String input = br.readLine();
        Character[] digits = new Character[input.length()];

        // 각 자리 숫자를 Character 배열로 변환
        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i);
        }

        // 내림차순 정렬
        Arrays.sort(digits, Collections.reverseOrder());

        // 결과 출력
        for (char digit : digits) {
            System.out.print(digit);
        }
    }
}
