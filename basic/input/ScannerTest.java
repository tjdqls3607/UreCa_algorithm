package basic.input;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        // Scanner
        // 편리하나 상대적(java.io)으로 무겁다.
        // 매우 간단한 입력 처리에만 사용

//        // 1 2 3 4 5
//        {
//            Scanner sc = new Scanner(System.in);
//            int[] input = new int[5];
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = sc.nextInt();
//            }
//            System.out.println(Arrays.toString(input));
//        }

        // 1 A 2 B C
        {
            Scanner sc = new Scanner(System.in);
            char[] input = new char[5];

            for (int i = 0; i < 5; i++) {
                input[i] = sc.next().charAt(0); // "1" -> char '1'
            }
            System.out.println(Arrays.toString(input));
        }
    }
}
