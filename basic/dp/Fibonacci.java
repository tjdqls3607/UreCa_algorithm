package basic.dp;

public class Fibonacci {

    public static void main(String[] args) {
        // #1. 단순 재귀호출
        System.out.println(fibo_rc(5));

        // #2. 메모이제이션 (memoization)

        // #3. dp
    }
    static long fibo_rc(int n) {
        if (n == 1 || n == 2) return 1;
        return fibo_rc(n - 1) + fibo_rc(n - 2);
    }
}
