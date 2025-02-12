package baekjoon;


import java.io.IOException;
import java.util.Scanner;



// 5로 나눠 떨어지는 수 ( 5의 배수를 만들면 된다. )
// N이 5의 배수가 될때 가지 3을 사용한다.
public class bj_설탕 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        int count = 0;

        while (true) {  // 3과 5를 못 만드는 경우
            if (N < 0) {
                System.out.println("-1");
                break;
            }

            // N 을 5로 나누어 떨어지는지
            if (N % 5 == 0) {
                System.out.println(N / 5 + count);
                break;
            }

            // 3 하나 사용
            N -= 3;
            count++;
        }
    }
}
