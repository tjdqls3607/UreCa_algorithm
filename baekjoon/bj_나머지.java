package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> remainderSet = new HashSet<>(); // 중복 없는 나머지를 저장할 Set
       for (int i = 0; i < 10; i++) {
           int a = Integer.parseInt(br.readLine());
           remainderSet.add(a%42);
       }
        System.out.println(remainderSet.size());
    }
}
