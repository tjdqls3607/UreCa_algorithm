package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_직각삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int[] sides = new int[3];
            sides[0] = sc.nextInt();
            sides[1] = sc.nextInt();
            sides[2] = sc.nextInt();

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }

            Arrays.sort(sides);
            if (sides[0]*sides[0] + sides[1]*sides[1] == sides[2]*sides[2]) {
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }
        }



    }
}
