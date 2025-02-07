package basic.recursive;

// fatorial 계산을 재귀호출을 이용해서 처리, 결과값 처리 다양하게
public class Test2 {
    public static void main(String[] args) {
        factorial(5);
        int result = factorial2(5);
        System.out.println(result);
    }

    // #1. 결과값을 static 변수
    static int result = 1;
    static void factorial(int n){
        // 기저조건
        if(n==1) {
            System.out.println(result);
            return;
        }
        // 계산
        result = n*result;

        // 재귀호출
        factorial(n-1);
    }

    // #2. 결과값을 재귀호출의 return 값으로
    // 바닥부터 계산되어서 bottom up 으로 처리
    static int factorial2(int n){
        // 기저조건
        if(n==1) return 1;
        // n == 3 일 때
        // 2 X 1의 결과에 자신 3을 곱해서 4에게 리턴
        return n*factorial2(n-1);
    }
}
