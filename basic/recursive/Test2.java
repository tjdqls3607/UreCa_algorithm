package basic.recursive;

// fatorial 계산을 재귀호출을 이용해서 처리, 결과값 처리 다양하게
public class Test2 {
    public static void main(String[] args) {
        factorial(5);
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
}
