package basic.recursive;

public class Test {
    public static void main(String[] args) {
//        m1();
        m1_param(0);
    }

    //// 변수
    static int m1_i = 0;
    static void m1() {
        // local 변수 <= 재귀호출마다 스택에 새로 만들어지고 초기화 된다.
//        int i = 0;
//        System.out.println("m1()" + i++);

        // static 변수 <= 재귀호출마다 공유
        System.out.println("m1() " + m1_i++);
        m1();
    }

    static void m1_param(int i) {
        // 파라미터 변수 <= 재귀호출마다 스택에 새로 만들어지고 이전 호출에서 전달된 값을 복사
        System.out.println("m1_param() " + i++);
        m1_param(i);
    }
}
