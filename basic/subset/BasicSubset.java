package basic.subset;

import javax.swing.*;

public class BasicSubset {

    // 기본 부분집합
    // 부분집합의 경우의 수는 모든 가능한 조합의 수의 합

    static int[] src = {1, 2, 3, 4, 5};
    // tgt 배열 X <= 정해진 수의 선택을 하는 것이 아니라, 가능한 모든 경우를 선택
    // 조합은 src, tgt 맨 앞부터 선택/비선택을 해 가면서 tgt를 채추면 끝 이지만
    // 부분 집합은 src 의 맨 앞부터 선택/비선택을 끝까지 계속 한다.

    static boolean[] select = new boolean[src.length];  // 선택, 비선택 상태를 저장하는 자료 구조

    public static void main(String[] args) {
        subset(0);  //맨 앞자리 부터
    }

    static void subset(int srcIdx) {
        // 기저조건
        if (srcIdx == src.length) {
            // 부분집합 경우가 완성
            printSubset();
            return;
        }

        // 현 srcIdx 를 선책, 비선택
        select[srcIdx] = true;
        subset(srcIdx + 1);

        select[srcIdx] = false;
        subset(srcIdx + 1);
    }
    // 부분집합이 완성되면 select 배열을 기준으로 src 의 선택된 수 출력
    static void printSubset() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < select.length; i++) {
            if (select[i]) sb.append(src[i]).append(" ");
        }
        System.out.println(sb);
    }
}
