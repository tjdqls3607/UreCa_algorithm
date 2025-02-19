package basic.dp;

public class Fibonacci {

    public static void main(String[] args) {
        // #1. 단순 재귀호출
    //    System.out.println(fibo_rc(15));    // 오래 걸린다.

        // #2. 메모이제이션 (memoization)
//        System.out.println(fibo_rc_memoi(50));

        // #3. dp
        System.out.println(fibo_dp(50));

    }
    static long fibo_rc(int n) {
        if (n == 1 || n == 2) return 1;
        return fibo_rc(n - 1) + fibo_rc(n - 2);
    }
    static long[] memoi_rc = new long[51];  // 처음 만들면 0 으로 초기화

    static long fibo_rc_memoi(int n) {
        if (n == 1 || n == 2) return 1;
        // 이미 n 에대해서 사전에 수행되고 기록된 결과가 존재하는 지 확인
        if (memoi_rc[n] > 0) return memoi_rc[n];    // 이전 수행되고, 기록된 결과를 재활용
        else return memoi_rc[n] =
                fibo_rc_memoi(n - 1) + fibo_rc_memoi(n - 2);
        // n 대해 최초 실행, 기록
    }

    static long[] memoi_dp = new long[51];

    // 점화식을 세우고 전 -> 후 점화식을 단계별로 적용 (계산)한 결과를 메모이제이션 자료구조에 저장, 활용
    static long fibo_dp(int n) {

        if (n == 1 || n == 2) return 1;

        memoi_dp[1] = 1;
        memoi_dp[2] = 1;

        // 반복문으로 점화식을 원하는 답에 맞게 계산
        for (int i=3; i<=n; i++) {
            memoi_dp[i] = memoi_dp[i-1] + memoi_dp[i-2];
        }
        return memoi_dp[n];
    }
}

// 기본적인 완탐 문제에서 시간초과가 발생하는 경우
// 더 효율적인 코드로 개선
//  1. 가지치기 ( 갈 필요가 없는 반복 탐색이 있는지)
//  2. 메모지 제이션 (반복적으로 수행되는 탐색이 존재하는가)


// dp 풀이는 문제에서 점화식을 파악해야 적용할 수 있다.
// 현재상태 => 미래 상태 고민X
// 과거 상태 => 현재 상태 고민O
// 점화식은 항상 이전 상태가 현재 상태를 만들 지 못할 수도 있다. dp 로 7 번째 답을 dp 의 6번째로 만들 지 못하는 경우도 있다..