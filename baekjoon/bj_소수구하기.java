package baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class bj_소수구하기 {
    static int N,M;
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         M = sc.nextInt();
         N = sc.nextInt();

         boolean [] isPrime = new boolean[N+1];
         Arrays.fill(isPrime, true);
         isPrime[0] = false;
         isPrime[1] = false;


         for (int i=2; i<=(int)Math.sqrt(N); i++) {
             if(!isPrime[i]) continue;
             for(int j=2*i; j<=N; j+=i) {
                 isPrime[j] = false;
             }
         }

         for (int i=M; i<isPrime.length; i++) {
             if(isPrime[i]) System.out.println(i);
         }

     }
}
