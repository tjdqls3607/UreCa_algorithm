package baekjoon;

import java.util.Scanner;

public class bj_복권 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // n 까지의 수
        int M = sc.nextInt();   // 고를 M개의 수
        int K = sc.nextInt();   // K개의 수가 같으면 당첨

        double res =0.0;
        double p = comb(n,M);

        while (M>=K) {
            if (n-M < M-K) {
                K++;
                continue;
            }
            double c = comb(M,K) * comb(n-M,M-K);

            res += c/p;
            K++;
        }
        System.out.println(res);
    }
    static long comb(int n, int r) {
        int p=1;
        int c=1;

        while (r>0) {
            c*=n--;
            p*=r--;
        }
        return c/p;
    }
}
