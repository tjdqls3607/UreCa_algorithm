package baekjoon;

import java.util.Scanner;

public class bj_알파벳찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
