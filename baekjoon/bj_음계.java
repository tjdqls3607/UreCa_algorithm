package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_음계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};

        if (Arrays.equals(arr,ascending)) {
            System.out.println("ascending");
        }else if (Arrays.equals(arr,descending)) {
            System.out.println("descending");
        }else {
            System.out.println("mixed");
        }
    }
}
