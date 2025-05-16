package baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class bj_나이순정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 테스트개수

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String name = sc.next();
            list.add(new String[]{s, name, String.valueOf(i)});
        }

        list.sort((a ,b) -> {
            int compare = Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
            return compare;
        });

        for (String[] person : list) {
            System.out.println(person[0] + " " + person[1]);
        }
    }
}
