package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj_단어정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 테케수
        sc.nextLine();  // 개행 문자 제거

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();   // 길이순 정렬
                }else {
                    return o1.compareTo(o2);    // 사전순 정렬
                }
            }
        });

        System.out.println(str[0]);
        for (int i = 1; i < n; i++) {
            if (!str[i].equals(str[i - 1])) {
                System.out.println(str[i]);
            }
        }
    }
}
